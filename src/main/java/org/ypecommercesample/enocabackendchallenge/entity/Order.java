package org.ypecommercesample.enocabackendchallenge.entity;

import org.ypecommercesample.enocabackendchallenge.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity {

    // Sipariş kodu - benzersiz olmalı
    @Column(unique = true, nullable = false)
    private String orderCode;

    // Siparişi veren müşteri
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Siparişteki ürünler
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    // Toplam fiyat
    private BigDecimal totalPrice;

    // Sipariş durumu
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

}
