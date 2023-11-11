package com.nayo.karenkou.a.emmanuel.car_rental_management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Employee;
import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.EmployeeType;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByNomAndAdresse(String nom, String adress);

    List<Employee> findByNom(String nom);

    // Find employee by post
    List<Employee> findByPoste(String poste);

    List<Employee> findByType(EmployeeType type);
    
}
