package com.nayo.karenkou.a.emmanuel.car_rental_management.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.EmployeeDTO;
import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.EmployeeType;

public interface EmployeeRestAPI {

    @PostMapping("/employees/create")
    ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO);

    @PutMapping("/employees/update/{id}")
    ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable("id") Long employee_id);
    
    @GetMapping("/employees/{id}")
    ResponseEntity<EmployeeDTO> findById(@PathVariable("id") Long employee_id);
    
    @DeleteMapping("/employees/delete/{id}")
    ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employee_id);

    /*@GetMapping("/employees/poste/{poste}")
    ResponseEntity<EmployeeDTO> findByPost(@PathVariable("poste") String poste);*/
    
    @GetMapping("/employees")
    List<EmployeeDTO> findAll();
    
    @GetMapping("/employees/all/{name}")
    List<EmployeeDTO> findByNom(@PathVariable("name") String nom);
    
    @GetMapping("/employees/all_poste/{poste}")
    List<EmployeeDTO> findByPoste(@PathVariable("poste") String poste);

    @GetMapping("/employees/type/{type}")
    List<EmployeeDTO> findByType(@PathVariable("type") EmployeeType type);
    
}
