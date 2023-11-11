package com.nayo.karenkou.a.emmanuel.car_rental_management.api;

// import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.CustomerDTO;
import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.EmployeeDTO;
import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.RentalDTO;
import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.request.CarRequest;
import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.RentalStatus;

public interface RentalRestAPI {

    @PostMapping("/rentals/create")
    ResponseEntity<RentalDTO> createRent(@RequestBody RentalDTO rentDTO);

    @PutMapping("/rentals/update/{id}")
    ResponseEntity<RentalDTO> updateRental(@RequestBody RentalDTO rentDTO, @PathVariable("id") Long rent_id);

    @GetMapping("/rentals/{id}")
    ResponseEntity<RentalDTO> findById(@PathVariable("id") Long rent_id);

    @DeleteMapping("/rentals/delete/{id}")
    ResponseEntity<String> deleteRent(@PathVariable("id") Long rent_id);

    @GetMapping("/rentals")
    List<RentalDTO> findAll();

    // List<RentalDTO> findByDateDeLocation(LocalDate dateDeLocation);

    // @GetMapping("/rentals/employee")
    // List<RentalDTO> findByEmployee(@RequestBody EmployeeDTO employeeDTO);

    // @GetMapping("/rentals/customer")
    // List<RentalDTO> findByCustomer(@RequestBody CustomerDTO customerDTO);

    // @GetMapping("/rentals/car")
    // List<RentalDTO> findByCar(@RequestBody CarRequest carRequest);

    @GetMapping("/rentals/status/{status}")
    List<RentalDTO> findByStatus(@PathVariable("status") RentalStatus status);
    
}
