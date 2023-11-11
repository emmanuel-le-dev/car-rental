package com.nayo.karenkou.a.emmanuel.car_rental_management.dtos;

import java.time.LocalDate;

import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.request.CarRequest;
import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.request.EmployeeRequest;
import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.RentalStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {

    // private Long rental_id;

    private LocalDate dateDeLocation;
    private Integer dureeDeLocation;
    private EmployeeRequest employee;
    private CustomerDTO customer;
    private CarRequest car;
    private RentalStatus status;
    
}
