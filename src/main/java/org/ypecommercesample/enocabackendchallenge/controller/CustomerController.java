package org.ypecommercesample.enocabackendchallenge.controller;

import org.ypecommercesample.enocabackendchallenge.dto.CustomerDto;
import org.ypecommercesample.enocabackendchallenge.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        CustomerDto customerDTO = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerDTO);
    }
}