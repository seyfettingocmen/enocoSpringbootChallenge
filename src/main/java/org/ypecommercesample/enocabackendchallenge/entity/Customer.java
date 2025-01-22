package org.ypecommercesample.enocabackendchallenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer extends BaseEntity {

    // Müşteri adı
    @Column(nullable = false)
    private String name;

    // Email adresi - benzersiz olmalı
    @Column(unique = true, nullable = false)
    private String email;
    // Müşterinin sepeti - one-to-one ilişki
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart cart;

    // Müşterinin siparişleri - one-to-many ilişki
    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();
}
