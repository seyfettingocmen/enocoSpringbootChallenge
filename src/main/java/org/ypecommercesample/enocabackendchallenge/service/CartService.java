package org.ypecommercesample.enocabackendchallenge.service;

import org.ypecommercesample.enocabackendchallenge.dto.CartDto;
import org.ypecommercesample.enocabackendchallenge.dto.CustomerDto;
import org.ypecommercesample.enocabackendchallenge.entity.Cart;
import org.ypecommercesample.enocabackendchallenge.entity.CartItem;
import org.ypecommercesample.enocabackendchallenge.exception.BusinessException;
import org.ypecommercesample.enocabackendchallenge.mapper.CartMapper;
import org.ypecommercesample.enocabackendchallenge.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;
    private final CustomerService customerService;

    public CartDto addProductToCart(Long cartId, Long productId, Integer quantity) {
        Cart cart = cartRepository.findById(cartId);

        if (!productService.hasEnoughStock(productId, quantity)) {
            throw new BusinessException("Not enough stock");
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(productService.getProduct(productId));
        cartItem.setQuantity(quantity);
        cartItem.setPriceAtAdd(cartItem.getProduct().getPrice());
        cartItem.setCart(cart);

        cart.getItems().add(cartItem);
        updateCartTotal(cart);

        cart = cartRepository.save(cart);
        return CartMapper.toCartDTO(cart);
    }

    public CartDto removeProductFromCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId);

        cart.getItems().removeIf(item -> item.getProduct().getId().equals(productId));
        updateCartTotal(cart);

        cart = cartRepository.save(cart);
        return CartMapper.toCartDTO(cart);
    }

    private void updateCartTotal(Cart cart) {
        BigDecimal total = cart.getItems().stream()
                .map(item -> item.getPriceAtAdd().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setTotalPrice(total);
    }

    public CartDto getCartByCustomerId(Long customerId) {
        CustomerDto customer = customerService.getCustomerById(customerId);
        Cart cart = cartRepository.findByCustomerId(customer.getId())
                .orElseThrow(() -> new BusinessException("Cart not found"));
        return CartMapper.toCartDTO(cart);
    }
}