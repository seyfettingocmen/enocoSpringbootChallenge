package org.ypecommercesample.enocabackendchallenge.mapper;

import org.ypecommercesample.enocabackendchallenge.dto.ProductDto;
import org.ypecommercesample.enocabackendchallenge.entity.Product;
import org.ypecommercesample.enocabackendchallenge.request.ProductRequest;

public class ProductMapper {

    public static ProductDto toProductDTO(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStockQuantity(product.getStockQuantity());
        dto.setIsActive(product.getIsActive());
        return dto;
    }

    public static Product toProduct(ProductRequest dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStockQuantity(dto.getStockQuantity());
        product.setIsActive(dto.getIsActive());
        return product;
    }
}