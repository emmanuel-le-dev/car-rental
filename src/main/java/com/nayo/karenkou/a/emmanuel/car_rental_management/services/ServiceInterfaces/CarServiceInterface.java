package com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceInterfaces;

import java.util.List;

import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Car;

public interface CarServiceInterface {

    Car createCar(Car car);

    Car updateCar(Car car, Long car_id);

    Car findById(Long car_id);

    void deleteCar(Long car_id);

    Car findByNumeroImmatriculation(String numeroImmatriculation);

    List<Car> findAll();

    List<Car> findByMarque(String marque);
    
}
