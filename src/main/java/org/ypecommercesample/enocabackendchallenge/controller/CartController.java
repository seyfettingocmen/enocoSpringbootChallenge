package org.ypecommercesample.enocabackendchallenge.controller;

import org.ypecommercesample.enocabackendchallenge.dto.CartDto;
import org.ypecommercesample.enocabackendchallenge.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/{cartId}/products")
    public ResponseEntity<CartDto> addProductToCart(@PathVariable Long cartId,
                                                    @RequestParam Long productId,
                                                    @RequestParam Integer quantity) {
        CartDto cartDTO = cartService.addProductToCart(cartId, productId, quantity);
        return ResponseEntity.ok(cartDTO);
    }

    @DeleteMapping("/{cartId}/products/{productId}")
    public ResponseEntity<CartDto> removeProductFromCart(@PathVariable Long cartId,
                                                         @PathVariable Long productId) {
        CartDto cartDTO = cartService.removeProductFromCart(cartId, productId);
        return ResponseEntity.ok(cartDTO);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CartDto> getCartByCustomerId(@PathVariable Long customerId) {
        CartDto cartDTO = cartService.getCartByCustomerId(customerId);
        return ResponseEntity.ok(cartDTO);
    }
}