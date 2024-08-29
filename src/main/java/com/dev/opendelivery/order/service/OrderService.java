package com.dev.opendelivery.order.service;

import com.dev.opendelivery.order.exception.EntityNotFoundException;
import com.dev.opendelivery.order.model.Order;
import com.dev.opendelivery.order.model.vo.*;
import com.dev.opendelivery.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderEventService eventService;

    public Order save(Order order) {
        order.setId(UUID.randomUUID());
        order.setCreatedAt(LocalDateTime.now());

        var delivery = new DeliveryAddress();
        delivery.setFormattedAddress(delivery.formattedAddress());

        var saveOrder = repository.save(order);
        var orders = repository.findAllSourceAppIdByMerchantId(order.getMerchantId());
        orders.forEach(order1 -> eventService.orderCreate(saveOrder.getId(), order1.getSourceApp()));

        return findById(saveOrder.getId());
    }

    public Order findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("pedido.nao.encontrado"));
    }

    public void confirm(UUID orderId, OrderConfirmVO confirm) {
        var orderConfirm = repository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("pedido.nao.encontrado"));
        orderConfirm(orderId, confirm);
        var orders = repository.findAllSourceAppIdByMerchantId(orderConfirm.getMerchantId());
        orders.forEach(order -> eventService.orderConfirm(orderId, order.getSourceApp(), confirm));
    }

    public void readyForPickup(UUID orderId) {
        var orderBy = repository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("pedido.nao.encontrado"));
        List<Order> orders = repository.findAllSourceAppIdByMerchantId(orderBy.getMerchantId());
        orders.forEach(order -> eventService.orderReadyForPickup(orderId, order.getSourceApp()));
    }

    public void dispatch(UUID orderId) {
        var orderBy = repository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("pedido.nao.encontrado"));
        List<Order> orders = repository.findAllSourceAppIdByMerchantId(orderBy.getMerchantId());
        orders.stream().map(Order::getSourceApp).forEach(sourceApp -> orders.removeIf(o -> o.getSourceApp().equals(sourceApp)));
        orders.forEach(order -> eventService.orderDispatch(orderId, order.getSourceApp()));
    }

    private void orderConfirm(UUID orderId, OrderConfirmVO confirm) {
        var confirmed = repository.confirmOrderByExternalCode(confirm.getOrderExternalCode());
        confirmed.ifPresentOrElse(
                orderExisting -> {
                    confirm.setConfirmed(true);
                    confirm.setConfirmedAt(LocalDateTime.now());
                    confirm.setOrderExternalCode(UUID.randomUUID().toString());
                    eventService.orderConfirm(orderId, orderExisting.getSourceApp(), confirm);
                    repository.save(orderExisting);
                }, () -> {
                    throw new EntityNotFoundException("pedido.nao.encontrado");
                }
        );
    }

}
