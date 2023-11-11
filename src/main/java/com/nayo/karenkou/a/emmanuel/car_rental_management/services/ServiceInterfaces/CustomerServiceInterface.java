package com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceInterfaces;

import java.util.List;

import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Customer;

public interface CustomerServiceInterface {

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer, Long customer_id);

    Customer findById(Long customer_id);

    void deleteCustomer(Long customer_id);

    Customer findByNumeroCIN(String numeroCIN);

    List<Customer> findAll();

    List<Customer> findByNom(String nom);
    
}
