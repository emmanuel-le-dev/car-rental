package com.nayo.karenkou.a.emmanuel.car_rental_management.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nayo.karenkou.a.emmanuel.car_rental_management.api.CarRestAPI;
import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.CarDTO;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Car;
import com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceInterfaces.CarServiceInterface;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class CarRestController implements CarRestAPI {

    private ModelMapper modelMapper;
    private CarServiceInterface carServiceInterface;

    @Override
    public ResponseEntity<CarDTO> createCar(CarDTO carDTO) {
        // throw new UnsupportedOperationException("Unimplemented method 'createCar'");

        // Convert DTO to ENTITY
        Car carRequest = modelMapper.map(carDTO, Car.class);
        Car car = carServiceInterface.createCar(carRequest);

        // Convert ENTITY to DTO
        CarDTO carResponse = modelMapper.map(car, CarDTO.class);

        return new ResponseEntity<CarDTO>(carResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CarDTO> updateCar(CarDTO carDTO, Long car_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'updateCar'");

        // Convert DTO to ENTITY
        Car carRequest = modelMapper.map(carDTO, Car.class);
        Car car = carServiceInterface.updateCar(carRequest, car_id);

        // Convert ENTITY to DTO
        CarDTO carResponse = modelMapper.map(car, CarDTO.class);

        return ResponseEntity.ok().body(carResponse);
    }

    @Override
    public ResponseEntity<CarDTO> findById(Long car_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'findById'");
        Car car = carServiceInterface.findById(car_id);

        // Convert ENTITY to DTO
        CarDTO carResponse = modelMapper.map(car, CarDTO.class);

        return ResponseEntity.ok().body(carResponse);
    }

    @Override
    public ResponseEntity<String> deleteCar(Long car_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'deleteCar'");
        carServiceInterface.deleteCar(car_id);

        return new ResponseEntity<String>("Car deleted successfuly", HttpStatus.OK);

    }

    @Override
    public ResponseEntity<CarDTO> findByNumeroImmatriculation(String numeroImmatriculation) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByNumeroImmatriculation'");
        Car car = carServiceInterface.findByNumeroImmatriculation(numeroImmatriculation);

        // Convert ENTITY to DTO
        CarDTO carResponse = modelMapper.map(car, CarDTO.class);

        return ResponseEntity.ok().body(carResponse);
    }

    @Override
    public List<CarDTO> findAll() {
        // throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        return carServiceInterface.findAll()
            .stream().map(car -> modelMapper.map(car, CarDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> findByMarque(String marque) {
        // throw new UnsupportedOperationException("Unimplemented method 'findAllByMarque'");
        return carServiceInterface.findByMarque(marque)
            .stream().map(car -> modelMapper.map(car, CarDTO.class))
            .collect(Collectors.toList());
    }
    
}
