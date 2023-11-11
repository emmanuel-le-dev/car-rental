package com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Customer;
import com.nayo.karenkou.a.emmanuel.car_rental_management.exceptions.DuplicateEntityException;
import com.nayo.karenkou.a.emmanuel.car_rental_management.exceptions.ResourceNotFoundException;
import com.nayo.karenkou.a.emmanuel.car_rental_management.repositories.CustomerRepository;
import com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceInterfaces.CustomerServiceInterface;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerServiceInterface {

    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        // throw new UnsupportedOperationException("Unimplemented method 'createCustomer'");

        // Check if the customer CIN is empty
        if (customer.getNumeroCIN().isEmpty()) {
            throw new IllegalArgumentException("Customer CIN cannot be empty");
        }

        // Check if the customer name is empty
        if (customer.getNom().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }

        // Check if the customer address is empty
        if (customer.getAdresse().isEmpty()) {
            throw new IllegalArgumentException("Customer address cannot be empty");
        }
        
        Customer existingCustomer = customerRepository.findByNumeroCIN(customer.getNumeroCIN());
        if (existingCustomer != null) {
            throw new DuplicateEntityException("A customer with the same CIN already exists");
        }

        // Save the customer to the database
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long customer_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");

        // Check if the customer ID is null
        if (customer_id == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }

        // Check if the customer exists
        Customer existingCustomer = customerRepository.findById(customer_id).orElseThrow(
            () -> new ResourceNotFoundException("Customer", "customer identifier", customer_id)
        );

        // Check if the customer CIN is empty
        if (customer.getNumeroCIN().isEmpty()) {
            throw new IllegalArgumentException("Customer CIN cannot be empty");
        }

        // Check if the customer name is empty
        if (customer.getNom().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }

        // Check if the customer address is empty
        if (customer.getAdresse().isEmpty()) {
            throw new IllegalArgumentException("Customer address cannot be empty");
        }

        // Update the customer's details
        existingCustomer.setNumeroCIN(customer.getNumeroCIN());
        existingCustomer.setNom(customer.getNom());
        existingCustomer.setAdresse(customer.getAdresse());

        // Save the updated customer to the database
        return existingCustomer;
    }

    @Override
    public Customer findById(Long customer_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'findById'");
        // Check if the customer ID is null
        if (customer_id == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }

        // Get the customer from the database
        return customerRepository.findById(customer_id).orElseThrow(
            () -> new ResourceNotFoundException("Customer", "customer identifier", customer_id)
        );
    }

    @Override
    public void deleteCustomer(Long customer_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
        // Check if the customer ID is null
        if (customer_id == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }

        // Get the customer from the database
        customerRepository.findById(customer_id).orElseThrow(
            () -> new ResourceNotFoundException("Customer", "customer identifier", customer_id)
        );

        customerRepository.deleteById(customer_id);
    }

    @Override
    public Customer findByNumeroCIN(String numeroCIN) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByNumeroCIN'");

        // Check if the customer CIN is null or empty
        if (numeroCIN == null || numeroCIN.isEmpty()) {
            throw new IllegalArgumentException("Customer CIN cannot be null or empty");
        }

        // Get the customer with the given CIN from the database
        return customerRepository.findByNumeroCIN(numeroCIN);
    }

    @Override
    public List<Customer> findAll() {
        // throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByNom(String nom) {
        // throw new UnsupportedOperationException("Unimplemented method 'findAllByNom'");

        // Check if the customer name is null or empty
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }

        // Get all customers with the given name from the database
        return customerRepository.findByNom(nom);
    }
    
}
