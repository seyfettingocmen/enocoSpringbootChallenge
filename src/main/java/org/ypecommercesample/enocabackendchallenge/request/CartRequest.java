package org.ypecommercesample.enocabackendchallenge.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartRequest {
    private Long customerId;
    private List<CartItemRequest> items;
}