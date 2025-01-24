package org.ypecommercesample.enocabackendchallenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity // Bu sınıfın bir JPA entity'si olduğunu belirtir.
@Table(name = "carts") // Veritabanında "carts" tablosuna karşılık gelir.
@Getter
@Setter
public class Cart extends BaseEntity {

    @OneToOne // Cart ve Customer arasında bire bir ilişki kurar.
    @JoinColumn(name = "customer_id", nullable = false) // customer_id sütunu ile ilişkilendirir.
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true) // CartItem ile bire çok ilişki.
    private List<CartItem> items = new ArrayList<>();

    @Column(nullable = false) // Toplam fiyat boş olamaz.
    private BigDecimal totalPrice = BigDecimal.ZERO; // Varsayılan değer sıfır olarak atanır.

    // Sepetin toplam fiyatını hesaplayan metod.
    public void calculateTotalPrice() {
        this.totalPrice = items.stream()
                .map(item -> item.getPriceAtAdd().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}