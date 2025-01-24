package org.ypecommercesample.enocabackendchallenge.mapper;

import org.ypecommercesample.enocabackendchallenge.dto.CustomerDto;
import org.ypecommercesample.enocabackendchallenge.entity.Customer;

public class CustomerMapper {

    public static CustomerDto toCustomerDTO(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        return dto;
    }

    public static Customer toCustomer(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        return customer;
    }
}