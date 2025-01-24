package org.ypecommercesample.enocabackendchallenge.mapper;

import org.ypecommercesample.enocabackendchallenge.dto.OrderDto;
import org.ypecommercesample.enocabackendchallenge.dto.OrderItemDto;
import org.ypecommercesample.enocabackendchallenge.entity.Order;
import org.ypecommercesample.enocabackendchallenge.entity.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDto toOrderDTO(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setOrderCode(order.getOrderCode());
        dto.setCustomerId(order.getCustomer().getId());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setStatus(order.getStatus().toString());
        dto.setItems(toOrderItemDTOList(order.getItems()));
        return dto;
    }

    public static List<OrderItemDto> toOrderItemDTOList(List<OrderItem> items) {
        return items.stream()
                .map(OrderMapper::toOrderItemDTO)
                .collect(Collectors.toList());
    }

    public static OrderItemDto toOrderItemDTO(OrderItem item) {
        OrderItemDto dto = new OrderItemDto();
        dto.setId(item.getId());
        dto.setProductId(item.getProduct().getId());
        dto.setProductName(item.getProduct().getName());
        dto.setQuantity(item.getQuantity());
        dto.setPriceAtPurchase(item.getPriceAtPurchase());
        return dto;
    }
}