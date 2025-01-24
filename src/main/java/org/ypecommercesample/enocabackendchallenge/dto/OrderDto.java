package org.ypecommercesample.enocabackendchallenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
public class OrderDto {    private Long id;
    private String orderCode;
    private Long customerId;
    private BigDecimal totalPrice;
    private String status;
    private List<OrderItemDto> items;
}
