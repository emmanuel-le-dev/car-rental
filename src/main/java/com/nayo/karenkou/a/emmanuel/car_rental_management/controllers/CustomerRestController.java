package com.nayo.karenkou.a.emmanuel.car_rental_management.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nayo.karenkou.a.emmanuel.car_rental_management.api.CustomerRestAPI;
import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.CustomerDTO;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Customer;
import com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceInterfaces.CustomerServiceInterface;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class CustomerRestController implements CustomerRestAPI {

    private ModelMapper modelMapper;
    private CustomerServiceInterface customerServiceInterface;

    @Override
    public ResponseEntity<CustomerDTO> createCustomer(CustomerDTO customerDTO) {
        // throw new UnsupportedOperationException("Unimplemented method 'createCustomer'");

        // Convert DTO to ENTITY
        Customer customerRequest = modelMapper.map(customerDTO, Customer.class);
        Customer customer = customerServiceInterface.createCustomer(customerRequest);

        // Convert ENTITY to DTO 
        CustomerDTO customerResponse = modelMapper.map(customer, CustomerDTO.class);

        return new ResponseEntity<CustomerDTO>(customerResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CustomerDTO> updateCustomer(CustomerDTO customerDTO, Long customer_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");

        // Convert DTO to ENTITY
        Customer customerRequest = modelMapper.map(customerDTO, Customer.class);
        Customer customer = customerServiceInterface.updateCustomer(customerRequest, customer_id);

        // Convert ENTITY to DTO
        CustomerDTO customerResponse = modelMapper.map(customer, CustomerDTO.class);

        return ResponseEntity.ok().body(customerResponse);
    }

    @Override
    public ResponseEntity<CustomerDTO> findById(Long customer_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'findById'");

        Customer customer = customerServiceInterface.findById(customer_id);

        // Convert ENTITY to DTO
        CustomerDTO customerResponse = modelMapper.map(customer, CustomerDTO.class);

        return ResponseEntity.ok().body(customerResponse);
    }

    @Override
    public ResponseEntity<String> deleteCustomer(Long customer_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");

        customerServiceInterface.deleteCustomer(customer_id);

        return new ResponseEntity<String>("Customer deleted successfuly", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomerDTO> findByNumeroCIN(String numeroCIN) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByNumeroCIN'");

        Customer customer = customerServiceInterface.findByNumeroCIN(numeroCIN);

        // Convert ENTITY to DTO
        CustomerDTO customerResponse = modelMapper.map(customer, CustomerDTO.class);

        return ResponseEntity.ok().body(customerResponse);
    }

    @Override
    public List<CustomerDTO> findAll() {
        // throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        return customerServiceInterface.findAll()
            .stream().map(customer -> modelMapper.map(customer, CustomerDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> findByNom(String nom) {
        // throw new UnsupportedOperationException("Unimplemented method 'findAllByNom'");
        return customerServiceInterface.findByNom(nom)
            .stream().map(customer -> modelMapper.map(customer, CustomerDTO.class))
            .collect(Collectors.toList());
    }
    
}
