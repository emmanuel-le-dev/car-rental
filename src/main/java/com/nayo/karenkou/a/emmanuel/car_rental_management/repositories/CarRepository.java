package com.nayo.karenkou.a.emmanuel.car_rental_management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByNumeroImmatriculation(String numeroImmatriculation);

    List<Car> findByMarque(String marque);
    
}
