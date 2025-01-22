package org.ypecommercesample.enocabackendchallenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem  extends BaseEntity{
    // Bağlı olduğu sepet
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    // Ürün
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Miktar
    private Integer quantity;

    // Ürünün sepete eklendiği andaki fiyatı
    private BigDecimal priceAtAdd;
}
