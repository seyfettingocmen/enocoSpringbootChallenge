package org.ypecommercesample.enocabackendchallenge.service;

import org.ypecommercesample.enocabackendchallenge.dto.CartDto;
import org.ypecommercesample.enocabackendchallenge.dto.OrderDto;
import org.ypecommercesample.enocabackendchallenge.entity.Order;
import org.ypecommercesample.enocabackendchallenge.entity.OrderItem;
import org.ypecommercesample.enocabackendchallenge.exception.BusinessException;
import org.ypecommercesample.enocabackendchallenge.mapper.CartMapper;
import org.ypecommercesample.enocabackendchallenge.mapper.OrderMapper;
import org.ypecommercesample.enocabackendchallenge.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;

    public OrderDto placeOrder(Long customerId) {
        CartDto cart = cartService.getCartByCustomerId(customerId);
        if (cart.getItems().isEmpty()) {
            throw new BusinessException("Cart is empty");
        }

        Order order = new Order();
        order.setCustomer(CartMapper.toCartDTO(cart.getCustomerDto()));
        order.setOrderCode(generateOrderCode());

        cart.getItems().forEach(cartItem -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPriceAtPurchase(cartItem.getPriceAtAdd());
            orderItem.setOrder(order);
            order.getItems().add(orderItem);
        });

        order.setTotalPrice(cart.getTotalPrice());
        cartService.emptyCart(cart.getId());

        order = orderRepository.save(order);
        return OrderMapper.toOrderDTO(order);
    }

    private String generateOrderCode() {
        return "ORD-" + System.currentTimeMillis();
    }

    public List<OrderDto> getCustomerOrders(Long customerId) {
        return orderRepository.findByCustomerId(customerId).stream()
                .map(OrderMapper::toOrderDTO)
                .collect(Collectors.toList());
    }

    public OrderDto getOrderByCode(String orderCode) {
        Order order = orderRepository.findByOrderCode(orderCode)
                .orElseThrow(() -> new BusinessException("Order not found"));
        return OrderMapper.toOrderDTO(order);
    }
}