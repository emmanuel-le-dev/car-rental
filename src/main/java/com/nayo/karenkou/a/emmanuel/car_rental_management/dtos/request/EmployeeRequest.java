package com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.request;

import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.EmployeeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    
    // private Long employee_id;
    private String nom;
    private String adresse;
    private EmployeeType type;

}
