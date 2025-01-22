package org.ypecommercesample.enocabackendchallenge.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ypecommercesample.enocabackendchallenge.entity.Customer;
import org.ypecommercesample.enocabackendchallenge.repository.CustomerRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find customer with id " + id));
    }
}
