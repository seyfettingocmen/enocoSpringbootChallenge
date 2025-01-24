package org.ypecommercesample.enocabackendchallenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity // Bu sınıfın bir JPA entity'si olduğunu belirtir.
@Table(name = "order_items") // Veritabanında "order_items" tablosuna karşılık gelir.
@Getter
@Setter
public class OrderItem extends BaseEntity {

    @ManyToOne // OrderItem ve Order arasında çoktan bire ilişki kurar.
    @JoinColumn(name = "order_id", nullable = false) // order_id sütunu ile ilişkilendirir.
    private Order order;

    @ManyToOne // OrderItem ve Product arasında çoktan bire ilişki kurar.
    @JoinColumn(name = "product_id", nullable = false) // product_id sütunu ile ilişkilendirir.
    private Product product;

    @Column(nullable = false) // Miktar boş olamaz.
    private Integer quantity;

    @Column(nullable = false) // Satın alma anındaki fiyat boş olamaz.
    private BigDecimal priceAtPurchase;
}