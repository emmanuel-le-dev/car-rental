package com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Car;
import com.nayo.karenkou.a.emmanuel.car_rental_management.repositories.CarRepository;
import com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceInterfaces.CarServiceInterface;
import com.nayo.karenkou.a.emmanuel.exceptions.DuplicateEntityException;
import com.nayo.karenkou.a.emmanuel.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CarServiceImpl implements CarServiceInterface {

    private CarRepository carRepository;

    @Override
    public Car createCar(Car car) {
        // throw new UnsupportedOperationException("Unimplemented method 'createCar'");

        // Check if the car's immatriculation number is empty
        if (car.getNumeroImmatriculation().isEmpty()) {
            throw new IllegalArgumentException("Car's immatriculation number cannot be empty");
        }

        // Check if the car's brand is empty
        if (car.getMarque().isEmpty()) {
            throw new IllegalArgumentException("Car's brand cannot be empty");
        }

        // Check if the car's acquisition date is null
        if (car.getDateAcquisition() == null) {
            throw new IllegalArgumentException("Car's acquisition date cannot be null");
        }

        // Check if the car already exists
        Car existingCar = carRepository.findByNumeroImmatriculation(car.getNumeroImmatriculation());
        if (existingCar != null) {
            // Throw an exception because the car already exists
            throw new DuplicateEntityException("A car with the same immatriculation number already exists");
        }

        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car, Long car_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'updateCar'");
        // Check if the car ID is null
        if (car_id == null) {
            throw new IllegalArgumentException("Car ID cannot be null");
        }

        // Check if the car exists
        Car existingCar = carRepository.findById(car_id).orElseThrow(
            () -> new ResourceNotFoundException("Car", "id", car_id)
        );

        // Check if the car's immatriculation number is empty
        if (car.getNumeroImmatriculation().isEmpty()) {
            throw new IllegalArgumentException("Car's immatriculation number cannot be empty");
        }

        // Check if the car's brand is empty
        if (car.getMarque().isEmpty()) {
            throw new IllegalArgumentException("Car's brand cannot be empty");
        }

        // Check if the car's acquisition date is null
        if (car.getDateAcquisition() == null) {
            throw new IllegalArgumentException("Car's acquisition date cannot be null");
        }

        // Update the car's details
        existingCar.setNumeroImmatriculation(car.getNumeroImmatriculation());
        existingCar.setMarque(car.getMarque());
        existingCar.setDateAcquisition(car.getDateAcquisition());

        // Save the updated car to the database
        return existingCar;
    }

    @Override
    public Car findById(Long car_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'findById'");

        // Check if the car ID is null
        if (car_id == null) {
            throw new IllegalArgumentException("Car ID cannot be null");
        }

        // Get the car from the database
        return carRepository.findById(car_id).orElseThrow(
            () -> new ResourceNotFoundException("Car", "id", car_id)
        );
    }

    @Override
    public void deleteCar(Long car_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'deleteCar'");
        // Check if the car ID is null
        if (car_id == null) {
            throw new IllegalArgumentException("Car ID cannot be null");
        }

        // Check if the car exists
        carRepository.findById(car_id).orElseThrow(
            () -> new ResourceNotFoundException("Car", "id", car_id)
        );

        // Delete the car from the database
        carRepository.deleteById(car_id);
    }

    @Override
    public Car findByNumeroImmatriculation(String numeroImmatriculation) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByNumeroImmatriculation'");

        // Check if the car's immatriculation number is empty
        if (numeroImmatriculation == null || numeroImmatriculation.isEmpty()) {
            throw new IllegalArgumentException("Car's immatriculation number cannot be empty");
        }

        return carRepository.findByNumeroImmatriculation(numeroImmatriculation);
    }

    @Override
    public List<Car> findAll() {
        // throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        
        return carRepository.findAll();
    }

    @Override
    public List<Car> findByMarque(String marque) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByMarque'");

        // Check if the car's brand is empty
        if (marque == null || marque.isEmpty()) {
            throw new IllegalArgumentException("Car's brand cannot be empty");
        }

        // Get all cars with the given brand from the database
        return carRepository.findByMarque(marque);
    }
    
}
