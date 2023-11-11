package com.nayo.karenkou.a.emmanuel.car_rental_management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find customer by CIN number
    Customer findByNumeroCIN(String numeroCIN);

    Customer findByNomAndNumeroCIN(String nom, String numeroCIN);

    // Find all customer with the same name
    List<Customer> findByNom(String nom);
    
}
