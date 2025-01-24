package org.ypecommercesample.enocabackendchallenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
public class CartDto {
    private Long id;
    private CustomerDto customerDto;
    private BigDecimal totalPrice;
    private List<CartItemDto> items;
}
