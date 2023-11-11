package com.nayo.karenkou.a.emmanuel.car_rental_management.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.CarDTO;

public interface CarRestAPI {

    @PostMapping("/cars/create")
    ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO);

    @PutMapping("/cars/update/{id}")
    ResponseEntity<CarDTO> updateCar(@RequestBody CarDTO carDTO, @PathVariable("id") Long car_id);

    @GetMapping("/cars/{id}")
    ResponseEntity<CarDTO> findById(@PathVariable("id") Long car_id);

    @DeleteMapping("/cars/delete/{id}")
    ResponseEntity<String> deleteCar(@PathVariable("id") Long car_id);

    @GetMapping("/cars/immatriculation/{immatriculation}")
    ResponseEntity<CarDTO> findByNumeroImmatriculation(@PathVariable("immatriculation") String numeroImmatriculation);

    @GetMapping("/cars")
    List<CarDTO> findAll();

    @GetMapping("/cars/all_marque/{marque}")
    List<CarDTO> findByMarque(@PathVariable("marque") String marque);
    
}
