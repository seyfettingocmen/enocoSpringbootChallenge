package org.ypecommercesample.enocabackendchallenge.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ypecommercesample.enocabackendchallenge.entity.Cart;
import org.ypecommercesample.enocabackendchallenge.service.CartService;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/{cartId}/products")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long cartId,
                                                 @RequestParam Long productId,
                                                 @RequestParam Integer quantity) {
        return ResponseEntity.ok(cartService.addProductToCart(Math.toIntExact(cartId), productId, quantity));
    }

    @DeleteMapping("/{cartId}/products/{productId}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable Long cartId,
                                                      @PathVariable Long productId) {
        return ResponseEntity.ok(cartService.removeProductFromCart(Math.toIntExact(cartId), productId));
    }
}
