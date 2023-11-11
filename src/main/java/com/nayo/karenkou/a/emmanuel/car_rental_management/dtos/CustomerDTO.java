package com.nayo.karenkou.a.emmanuel.car_rental_management.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String numeroCIN;
    private String nom;
    private String adresse;
    
}
