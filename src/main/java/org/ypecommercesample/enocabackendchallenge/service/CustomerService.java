package org.ypecommercesample.enocabackendchallenge.service;

import org.ypecommercesample.enocabackendchallenge.dto.CustomerDto;
import org.ypecommercesample.enocabackendchallenge.entity.Customer;
import org.ypecommercesample.enocabackendchallenge.exception.BusinessException;
import org.ypecommercesample.enocabackendchallenge.mapper.CustomerMapper;
import org.ypecommercesample.enocabackendchallenge.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Could not find customer with id " + id));
        return CustomerMapper.toCustomerDTO(customer);
    }
}