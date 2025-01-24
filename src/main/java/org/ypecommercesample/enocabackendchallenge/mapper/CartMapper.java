package org.ypecommercesample.enocabackendchallenge.mapper;

import org.ypecommercesample.enocabackendchallenge.dto.CartDto;
import org.ypecommercesample.enocabackendchallenge.dto.CartItemDto;
import org.ypecommercesample.enocabackendchallenge.entity.Cart;
import org.ypecommercesample.enocabackendchallenge.entity.CartItem;

import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {

    public static CartDto toCartDTO(Cart cart) {
        CartDto dto = new CartDto();
        dto.setId(cart.getId());
        dto.setCustomerDto(cart.getCustomer().getId());
        dto.setTotalPrice(cart.getTotalPrice());
        dto.setItems(toCartItemDTOList(cart.getItems()));
        return dto;
    }

    public static List<CartItemDto> toCartItemDTOList(List<CartItem> items) {
        return items.stream()
                .map(CartMapper::toCartItemDTO)
                .collect(Collectors.toList());
    }

    public static CartItemDto toCartItemDTO(CartItem item) {
        CartItemDto dto = new CartItemDto();
        dto.setId(item.getId());
        dto.setProductId(item.getProduct().getId());
        dto.setProductName(item.getProduct().getName());
        dto.setQuantity(item.getQuantity());
        dto.setPriceAtAdd(item.getPriceAtAdd());
        return dto;
    }
}