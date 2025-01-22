package org.ypecommercesample.enocabackendchallenge.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ypecommercesample.enocabackendchallenge.entity.Cart;
import org.ypecommercesample.enocabackendchallenge.entity.Order;
import org.ypecommercesample.enocabackendchallenge.entity.OrderItem;
import org.ypecommercesample.enocabackendchallenge.exception.BusinessException;
import org.ypecommercesample.enocabackendchallenge.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;

    // Sipariş oluşturma
    public Order placeOrder(Long customerId) {
        Cart cart = cartService.getCartByCustomerId(customerId);
        if (cart.getItems().isEmpty()) {
            throw new BusinessException("Cart is empty");
        }

        // Siparişi oluştur
        Order order = new Order();
        order.setCustomer(cart.getCustomer());
        order.setOrderCode(generateOrderCode());

        // Sepetteki ürünleri siparişe aktar
        cart.getItems().forEach(cartItem -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPriceAtPurchase(cartItem.getPriceAtAdd());
            orderItem.setOrder(order);
            order.getItems().add(orderItem);
        });

        order.setTotalPrice(cart.getTotalPrice());

        // Sepeti temizle
        cartService.emptyCart(cart.getId());

        return orderRepository.save(order);
    }

    // Sipariş kodu üretme
    private String generateOrderCode() {
        return "ORD-" + System.currentTimeMillis();
    }

    public List<Order> getCustomerOrders(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public Optional<Order> getOrderByCode(String orderCode) {
        return orderRepository.findByOrderCode(orderCode);
    }
}
