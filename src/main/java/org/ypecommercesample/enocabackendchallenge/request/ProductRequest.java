package org.ypecommercesample.enocabackendchallenge.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ProductRequest {
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
}
