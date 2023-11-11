package com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceInterfaces;

import java.util.List;

import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Employee;
import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.EmployeeType;

public interface EmployeeServiceInterface {

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee, Long employee_id);
    
    Employee findById(Long employee_id);
    
    void deleteEmployee(Long employee_id);
    
    List<Employee> findAll();
    
    List<Employee> findByNom(String nom);
    
    List<Employee> findByPoste(String poste);

    List<Employee> findByType(EmployeeType type);
    
}
