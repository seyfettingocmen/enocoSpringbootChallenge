package org.ypecommercesample.enocabackendchallenge.entity;

import org.ypecommercesample.enocabackendchallenge.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity // Bu sınıfın bir JPA entity'si olduğunu belirtir.
@Table(name = "orders") // Veritabanında "orders" tablosuna karşılık gelir.
@Getter
@Setter
public class Order extends BaseEntity {

    @Column(unique = true, nullable = false, length = 50) // Sipariş kodu benzersiz ve boş olamaz.
    private String orderCode;

    @ManyToOne // Order ve Customer arasında çoktan bire ilişki kurar.
    @JoinColumn(name = "customer_id", nullable = false) // customer_id sütunu ile ilişkilendirir.
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) // Order ve OrderItem arasında bire çok ilişki.
    private List<OrderItem> items = new ArrayList<>();

    @Column(nullable = false) // Toplam fiyat boş olamaz.
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING) // Enum değerini string olarak kaydeder.
    @Column(nullable = false) // Sipariş durumu boş olamaz.
    private OrderStatus status = OrderStatus.PENDING; // Varsayılan durum PENDING olarak atanır.

    // Siparişin toplam fiyatını hesaplayan metod.
    public void calculateTotalPrice() {
        this.totalPrice = items.stream()
                .map(item -> item.getPriceAtPurchase().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}