package org.ypecommercesample.enocabackendchallenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity // Bu sınıfın bir JPA entity'si olduğunu belirtir.
@Table(name = "cart_items") // Veritabanında "cart_items" tablosuna karşılık gelir.
@Getter
@Setter
public class CartItem extends BaseEntity {

    @ManyToOne // CartItem ve Cart arasında çoktan bire ilişki kurar.
    @JoinColumn(name = "cart_id", nullable = false) // cart_id sütunu ile ilişkilendirir.
    private Cart cart;

    @ManyToOne // CartItem ve Product arasında çoktan bire ilişki kurar.
    @JoinColumn(name = "product_id", nullable = false) // product_id sütunu ile ilişkilendirir.
    private Product product;

    @Column(nullable = false) // Miktar boş olamaz.
    private Integer quantity;

    @Column(nullable = false) // Ürünün sepete eklendiği andaki fiyatı boş olamaz.
    private BigDecimal priceAtAdd;
}