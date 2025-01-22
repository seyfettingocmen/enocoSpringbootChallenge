package org.ypecommercesample.enocabackendchallenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart extends BaseEntity{
    // Sepet sahibi müşteri
    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // Sepetteki ürünler
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();


    private BigDecimal totalPrice = BigDecimal.ZERO;
}
