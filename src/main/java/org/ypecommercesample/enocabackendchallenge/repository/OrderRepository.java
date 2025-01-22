package org.ypecommercesample.enocabackendchallenge.repository;

import org.ypecommercesample.enocabackendchallenge.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Sipariş kodu ile sipariş bulma
    Optional<Order> findByOrderCode(String orderCode);

    // Müşteriye ait tüm siparişleri bulma
    List<Order> findByCustomerId(Long customerId);
}
