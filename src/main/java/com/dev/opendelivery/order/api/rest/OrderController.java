package com.dev.opendelivery.order.api.rest;

import com.dev.opendelivery.order.model.*;
import com.dev.opendelivery.order.model.vo.OrderConfirmVO;
import com.dev.opendelivery.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

import static org.springframework.http.HttpStatus.ACCEPTED;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/pedidos")
public class OrderController {

    private final OrderService service;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable("id") UUID orderId) throws Exception {
        return ResponseEntity.ok(service.findById(orderId));
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody final Order order) throws Exception {
        return ResponseEntity.ok(service.save(order));
    }

    @PutMapping("/{id}/confirmacao")
    public ResponseEntity<OrderConfirmVO> confirm(@PathVariable("id") UUID orderId, @RequestBody(required = false) OrderConfirmVO orderConfirm) {
        service.confirm(orderId, orderConfirm);
        return ResponseEntity.status(ACCEPTED).build();
    }

    @PutMapping("/{id}/pronto-para-retirada")
    public ResponseEntity<Event> readyForPickup(@PathVariable("id") UUID orderId) {
        service.readyForPickup(orderId);
        return ResponseEntity.status(ACCEPTED).build();
    }

    @PutMapping("/{id}/despachar")
    public ResponseEntity<Event> dispatch(@PathVariable("id") UUID orderId) {
        service.dispatch(orderId);
        return ResponseEntity.status(ACCEPTED).build();
    }

}

