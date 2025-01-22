package org.ypecommercesample.enocabackendchallenge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends BaseEntity {

    //Ürün adı
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    // Ürün fiyatı - BigDecimal kullanılarak hassas hesaplama sağlanır
    @Column(nullable = false)
    private BigDecimal price;

    // Stok miktarı
    @Column(nullable = false)
    private Integer stockQuantity;
}
