package com.nayo.karenkou.a.emmanuel.car_rental_management.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nayo.karenkou.a.emmanuel.car_rental_management.api.RentalRestAPI;
import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.CustomerDTO;
import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.EmployeeDTO;
import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.RentalDTO;
import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.request.CarRequest;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Car;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Customer;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Employee;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Rental;
import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.RentalStatus;
import com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceInterfaces.RentalServiceInterface;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class RentalRestController implements RentalRestAPI {

    private ModelMapper modelMapper;
    private RentalServiceInterface rentalServiceInterface;

    @Override
    public ResponseEntity<RentalDTO> createRent(RentalDTO rentDTO) {
        // throw new UnsupportedOperationException("Unimplemented method 'createRent'");

        // Convert DTO to ENTITY
        Rental rentalRequest = modelMapper.map(rentDTO, Rental.class);

        // Create the rental
        Rental rental = rentalServiceInterface.createRent(rentalRequest);

        // Convert ENTITY to DTO
        RentalDTO rentalResponse = modelMapper.map(rental, RentalDTO.class);

        return new ResponseEntity<RentalDTO>(rentalResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RentalDTO> updateRental(RentalDTO rentDTO, Long rent_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'updateRental'");

        // Convert DTO to ENTITY
        Rental rentalRequest = modelMapper.map(rentDTO, Rental.class);
        Rental rental = rentalServiceInterface.updateRental(rentalRequest, rent_id);

        // Convert ENTITY to DTO
        RentalDTO rentalResponse = modelMapper.map(rental, RentalDTO.class);

        return ResponseEntity.ok().body(rentalResponse);
    }

    @Override
    public ResponseEntity<RentalDTO> findById(Long rent_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'findById'");
        Rental rental = rentalServiceInterface.findById(rent_id);

        // Convert ENTITY to DTO
        RentalDTO rentalResponse = modelMapper.map(rental, RentalDTO.class);
        return ResponseEntity.ok().body(rentalResponse);
    }

    @Override
    public ResponseEntity<String> deleteRent(Long rent_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'deleteRent'");
        rentalServiceInterface.deleteRent(rent_id);
        
        return new ResponseEntity<String>("Rental deleted successfuly", HttpStatus.OK);
    }

    @Override
    public List<RentalDTO> findAll() {
        // throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        return rentalServiceInterface.findAll()
            .stream().map(rental -> modelMapper.map(rental, RentalDTO.class))
            .collect(Collectors.toList());
    }

    /*
    @Override
    public List<RentalDTO> findByEmployee(EmployeeDTO employeeDTO) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByEmployee'");
        // Convert DTO to ENTITY
        Employee employeeRequest = modelMapper.map(employeeDTO, Employee.class);

        return rentalServiceInterface.findByEmployee(employeeRequest)
            .stream().map(rental -> modelMapper.map(rental, RentalDTO.class))
            .collect(Collectors.toList());

    }

    @Override
    public List<RentalDTO> findByCustomer(CustomerDTO customerDTO) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByCustomer'");
        // Convert DTO to ENTITY
        Customer customer = modelMapper.map(customerDTO, Customer.class);

        return rentalServiceInterface.findByCustomer(customer)
            .stream().map(rental -> modelMapper.map(rental, RentalDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public List<RentalDTO> findByCar(CarRequest carRequest) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByCar'");
        // Convert DTO to ENTITY
        Car car = modelMapper.map(carRequest, Car.class);

        return rentalServiceInterface.findByCar(car)
            .stream().map(rental -> modelMapper.map(rental, RentalDTO.class))
            .collect(Collectors.toList());
    }
     * 
     */

    @Override
    public List<RentalDTO> findByStatus(RentalStatus status) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByStatus'");
        return rentalServiceInterface.findByStatus(status)
            .stream().map(rental -> modelMapper.map(rental, RentalDTO.class))
            .collect(Collectors.toList());
    }
    
}
