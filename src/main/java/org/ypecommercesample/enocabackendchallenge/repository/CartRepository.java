package org.ypecommercesample.enocabackendchallenge.repository;

import org.ypecommercesample.enocabackendchallenge.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    // Müşteri ID'sine göre sepet bulma
    Optional<Cart> findByCustomerId(Long customerId);


    Cart findById(Long id);
}
