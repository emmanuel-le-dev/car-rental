package com.nayo.karenkou.a.emmanuel.car_rental_management.entities;

import java.time.LocalDate;
import java.util.List;

import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.EmployeeType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    private String nom;
    private String adresse;
    private Integer age;
    private String poste;
    private LocalDate dateDePromotion;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rentals;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;
    
}
