package com.dev.opendelivery.order.api.rest;

import com.dev.opendelivery.order.api.interfaces.IOrderController;
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
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable UUID orderId) throws Exception {
        return ResponseEntity.ok(service.findById(orderId));
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody final Order order) throws Exception {
        return ResponseEntity.ok(service.save(order));
    }

    @PutMapping("/{orderId}/confirm")
    public ResponseEntity<OrderConfirmVO> confirm(@PathVariable UUID orderId, @RequestBody(required = false) OrderConfirmVO orderConfirm) {
        service.confirm(orderId, orderConfirm);
        return ResponseEntity.status(ACCEPTED).build();
    }

    @PostMapping("/{orderId}/confirm")
    public ResponseEntity<OrderConfirmVO> confirm2(@PathVariable UUID orderId, @RequestBody(required = false) OrderConfirmVO orderConfirm) {
        service.confirm(orderId, orderConfirm);
        return ResponseEntity.status(ACCEPTED).build();
    }

    @PutMapping("/{orderId}/readyForPickup")
    public ResponseEntity<Event> readyForPickup(@PathVariable UUID orderId) {
        service.readyForPickup(orderId);
        return ResponseEntity.status(ACCEPTED).build();
    }

    @PostMapping("/{orderId}/readyForPickup")
    public ResponseEntity<Event> readyForPickup2(@PathVariable UUID orderId) {
        service.readyForPickup(orderId);
        return ResponseEntity.status(ACCEPTED).build();
    }

    @PutMapping("/{orderId}/dispatch")
    public ResponseEntity<Event> dispatch(@PathVariable UUID orderId) {
        service.dispatch(orderId);
        return ResponseEntity.status(ACCEPTED).build();
    }

    @PostMapping("/{orderId}/dispatch")
    public ResponseEntity<Event> dispatch2(@PathVariable UUID orderId) {
        service.dispatch(orderId);
        return ResponseEntity.status(ACCEPTED).build();
    }

}

