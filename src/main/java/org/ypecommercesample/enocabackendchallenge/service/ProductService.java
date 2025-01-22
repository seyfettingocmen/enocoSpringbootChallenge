package org.ypecommercesample.enocabackendchallenge.service;

import org.ypecommercesample.enocabackendchallenge.entity.Product;
import org.ypecommercesample.enocabackendchallenge.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ypecommercesample.enocabackendchallenge.repository.ProductRepository;
import org.ypecommercesample.enocabackendchallenge.request.ProductRequest;

// Ürün servisi
@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // Yeni Ürün oluşturma
    public Product createProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getProductName());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());
        return productRepository.save(product);
    }

    // Ürün güncelleme
    public Product updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Product not found"));

        product.setName(request.getProductName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());

        return productRepository.save(product);
    }
    // Ürün silme (soft delete)
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Product not found"));
        product.setIsActive(false);
        productRepository.save(product);
    }

    // Stok kontrolü
    public boolean hasEnoughStock(Long productId, Integer requestedQuantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new BusinessException("Product not found"));
        return product.getStockQuantity() >= requestedQuantity;
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new BusinessException("Product not found"));
    }
}
