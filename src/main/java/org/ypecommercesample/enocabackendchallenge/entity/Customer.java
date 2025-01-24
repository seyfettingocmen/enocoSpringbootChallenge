package org.ypecommercesample.enocabackendchallenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity // Bu sınıfın bir JPA entity'si olduğunu belirtir.
@Table(name = "customers") // Veritabanında "customers" tablosuna karşılık gelir.
@Getter
@Setter
public class Customer extends BaseEntity {

    @Column(nullable = false, length = 100) // Müşteri adı boş olamaz ve maksimum 100 karakter olabilir.
    private String name;

    @Column(unique = true, nullable = false, length = 100) // Email benzersiz ve boş olamaz.
    private String email;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL) // Customer ve Cart arasında bire bir ilişki.
    private Cart cart;

    @OneToMany(mappedBy = "customer") // Customer ve Order arasında bire çok ilişki.
    private List<Order> orders = new ArrayList<>();
}