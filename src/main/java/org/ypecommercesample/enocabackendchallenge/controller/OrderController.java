package org.ypecommercesample.enocabackendchallenge.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ypecommercesample.enocabackendchallenge.entity.Order;
import org.ypecommercesample.enocabackendchallenge.service.OrderService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/customers/{customerId}")
    public ResponseEntity<Order> placeOrder(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.placeOrder(customerId));
    }

    @GetMapping("/{orderCode}")
    public ResponseEntity<Optional<Order>> getOrderByCode(@PathVariable String orderCode) {
        return ResponseEntity.ok(orderService.getOrderByCode(orderCode));
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.getCustomerOrders(customerId));
    }
}
