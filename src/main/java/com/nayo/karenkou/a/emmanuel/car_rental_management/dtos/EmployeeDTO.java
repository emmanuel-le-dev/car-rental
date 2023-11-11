package com.nayo.karenkou.a.emmanuel.car_rental_management.dtos;

import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.EmployeeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    
    // private Long employee_id;

    private String nom;
    private String adresse;
    private Integer age;
    private String poste;
    private EmployeeType type;
    
}
