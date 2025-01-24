package org.ypecommercesample.enocabackendchallenge.controller;

import org.ypecommercesample.enocabackendchallenge.dto.OrderDto;
import org.ypecommercesample.enocabackendchallenge.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/customers/{customerId}")
    public ResponseEntity<OrderDto> placeOrder(@PathVariable Long customerId) {
        OrderDto orderDTO = orderService.placeOrder(customerId);
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("/{orderCode}")
    public ResponseEntity<OrderDto> getOrderByCode(@PathVariable String orderCode) {
        OrderDto orderDTO = orderService.getOrderByCode(orderCode);
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<OrderDto>> getCustomerOrders(@PathVariable Long customerId) {
        List<OrderDto> orders = orderService.getCustomerOrders(customerId);
        return ResponseEntity.ok(orders);
    }
}