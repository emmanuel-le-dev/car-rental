package com.nayo.karenkou.a.emmanuel.car_rental_management.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.CustomerDTO;

public interface CustomerRestAPI {

    @PostMapping("/customers/create")
    ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO);

    @PutMapping("/customers/update/{id}")
    ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable("id") Long customer_id);

    @GetMapping("/customers/{id}")
    ResponseEntity<CustomerDTO> findById(@PathVariable("id") Long customer_id);

    @DeleteMapping("/customers/delete/{id}")
    ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customer_id);

    @GetMapping("/customers/get_cin/{cin}")
    ResponseEntity<CustomerDTO> findByNumeroCIN(@PathVariable("cin") String numeroCIN);

    @GetMapping("/customers")
    List<CustomerDTO> findAll();

    @GetMapping("/customers/all_name/{name}")
    List<CustomerDTO> findByNom(@PathVariable("name") String nom);
    
}
