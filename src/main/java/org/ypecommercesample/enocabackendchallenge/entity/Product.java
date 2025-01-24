package org.ypecommercesample.enocabackendchallenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity // Bu sınıfın bir JPA entity'si olduğunu belirtir.
@Table(name = "products") // Veritabanında "products" tablosuna karşılık gelir.
@Getter
@Setter
public class Product extends BaseEntity {

    @Column(nullable = false, length = 100) // Ürün adı boş olamaz ve maksimum 100 karakter olabilir.
    private String name;

    @Column(nullable = false, length = 500) // Ürün açıklaması boş olamaz ve maksimum 500 karakter olabilir.
    private String description;

    @Column(nullable = false, precision = 10, scale = 2) // Fiyat boş olamaz ve 10 basamak, 2 ondalık hassasiyetinde olmalı.
    private BigDecimal price;

    @Column(nullable = false) // Stok miktarı boş olamaz.
    private Integer stockQuantity;
}