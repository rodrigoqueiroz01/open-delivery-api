package com.dev.opendelivery.order.service;

import com.dev.opendelivery.order.exception.EntityNotFoundException;
import com.dev.opendelivery.order.model.Order;
import com.dev.opendelivery.order.model.vo.*;
import com.dev.opendelivery.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

import static java.util.Objects.isNull;

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

        for (Order o : orders) {
            eventService.orderCreate(saveOrder.getId(), o.getSourceApp());
        }

        return findById(saveOrder.getId());
    }

    public Order findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("pedido.nao.encontrado"));
    }

    public void confirm(UUID orderId, OrderConfirmVO confirm) {
        var order = repository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("pedido.nao.encontrado"));

        var orderConfirm = repository.confirmOrderByExternalCode(confirm.getOrderExternalCode());
        orderConfirm.ifPresentOrElse(
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

        var orders = repository.findAllSourceAppIdByMerchantId(order.getMerchantId());
        for (Order o : orders) {
            eventService.orderConfirm(orderId, o.getSourceApp(), confirm);
        }
    }

    public void readyForPickup(UUID orderId) {
        var order = repository.findById(orderId).orElseThrow(() ->
                new EntityNotFoundException("pedido.nao.encontrado"));

        List<Order> orders = repository.findAllSourceAppIdByMerchantId(order.getMerchantId());
        for (Order o : orders) {
            eventService.orderReadyForPickup(orderId, o.getSourceApp());
        }
    }

    public void dispatch(UUID orderId) {
        var order = repository.findById(orderId).orElseThrow(() ->
                new EntityNotFoundException("pedido.nao.encontrado"));

        List<Order> orders = repository.findAllSourceAppIdByMerchantId(order.getMerchantId());
        orders.stream().map(Order::getSourceApp).forEach(sourceApp ->
                orders.removeIf(o -> o.getSourceApp().equals(sourceApp)));

        for (Order o : orders) {
            eventService.orderDispatch(orderId, o.getSourceApp());
        }
    }

}
