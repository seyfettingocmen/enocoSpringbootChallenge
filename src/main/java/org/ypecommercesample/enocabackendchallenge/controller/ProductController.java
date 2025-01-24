package org.ypecommercesample.enocabackendchallenge.controller;

import org.ypecommercesample.enocabackendchallenge.dto.ProductDto;
import org.ypecommercesample.enocabackendchallenge.request.ProductRequest;
import org.ypecommercesample.enocabackendchallenge.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductRequest request) {
        ProductDto productDTO = productService.createProduct(request);
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
        ProductDto productDTO = productService.updateProduct(id, request);
        return ResponseEntity.ok(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        ProductDto productDTO = productService.getProduct(id);
        return ResponseEntity.ok(productDTO);
    }
}