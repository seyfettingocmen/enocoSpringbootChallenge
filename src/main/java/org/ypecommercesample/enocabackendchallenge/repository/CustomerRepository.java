package org.ypecommercesample.enocabackendchallenge.repository;

import org.ypecommercesample.enocabackendchallenge.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Email ile müşteri bulma
    Optional<Customer> findByEmail(String email);
}
