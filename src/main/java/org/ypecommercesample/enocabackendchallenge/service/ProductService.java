package org.ypecommercesample.enocabackendchallenge.service;

import org.ypecommercesample.enocabackendchallenge.dto.ProductDTO;
import org.ypecommercesample.enocabackendchallenge.dto.ProductDto;
import org.ypecommercesample.enocabackendchallenge.entity.Product;
import org.ypecommercesample.enocabackendchallenge.exception.BusinessException;
import org.ypecommercesample.enocabackendchallenge.mapper.ProductMapper;
import org.ypecommercesample.enocabackendchallenge.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ypecommercesample.enocabackendchallenge.request.ProductRequest;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // Yeni ürün oluşturma.
    public ProductDto createProduct(ProductRequest request) {
        Product product = ProductMapper.toProduct(request);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    // Ürün güncelleme.
    public ProductDto updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Product not found"));
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    // Ürün silme (soft delete).
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Product not found"));
        product.setIsActive(false);
        productRepository.save(product);
    }

    // Ürün getirme.
    public ProductDto getProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new BusinessException("Product not found"));
        return ProductMapper.toProductDTO(product);
    }

    // Stok kontrolü.
    public boolean hasEnoughStock(Long productId, Integer quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new BusinessException("Product not found"));
        return product.getStockQuantity() >= quantity; // Stok miktarı istenen miktardan fazla veya eşitse true döner.
    }
}