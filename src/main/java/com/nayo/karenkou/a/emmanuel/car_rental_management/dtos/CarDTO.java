package com.nayo.karenkou.a.emmanuel.car_rental_management.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    // private Long car_id;

    private String numeroImmatriculation;
    private String marque;
    private LocalDate dateAcquisition;
    
}
