package org.ypecommercesample.enocabackendchallenge.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ypecommercesample.enocabackendchallenge.entity.Cart;
import org.ypecommercesample.enocabackendchallenge.entity.CartItem;
import org.ypecommercesample.enocabackendchallenge.entity.Customer;
import org.ypecommercesample.enocabackendchallenge.exception.BusinessException;
import org.ypecommercesample.enocabackendchallenge.repository.CartRepository;

import java.math.BigDecimal;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;
    private final CustomerService customerService;

    // Sepete ürün ekleme
    public Cart addProductToCart(Integer cartId, Long productId, Integer quantity) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new BusinessException("Cart not found"));

        // Stok kontrolü
        if (!productService.hasEnoughStock(productId, quantity)) {
            throw new BusinessException("Not enough stock");
        }

        // Ürünü sepete ekle
        CartItem cartItem = new CartItem();
        cartItem.setProduct(productService.getProduct(productId));
        cartItem.setQuantity(quantity);
        cartItem.setPriceAtAdd(cartItem.getProduct().getPrice());
        cartItem.setCart(cart);

        cart.getItems().add(cartItem);
        updateCartTotal(cart);

        return cartRepository.save(cart);
    }

    // Sepetten ürün çıkarma
    public Cart removeProductFromCart(Integer cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new BusinessException("Cart not found"));

        cart.getItems().removeIf(item -> item.getProduct().getId().equals(productId));
        updateCartTotal(cart);

        return cartRepository.save(cart);
    }

    // Sepet toplamını güncelleme
    private void updateCartTotal(Cart cart) {
        BigDecimal total = cart.getItems().stream()
                .map(item -> item.getPriceAtAdd().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setTotalPrice(total);
    }

    public void emptyCart(Long id) {
        cartRepository.deleteAll();
    }

    public Cart getCartByCustomerId(Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return cartRepository.findById(customer.getId());
    }
}
