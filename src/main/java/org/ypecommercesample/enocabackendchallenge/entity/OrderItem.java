package org.ypecommercesample.enocabackendchallenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter
@Setter
public class OrderItem extends BaseEntity {
    // Bağlı olduğu sipariş
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Ürün
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Miktar
    private Integer quantity;

    // Satın alma anındaki fiyat
    private BigDecimal priceAtPurchase;

}
