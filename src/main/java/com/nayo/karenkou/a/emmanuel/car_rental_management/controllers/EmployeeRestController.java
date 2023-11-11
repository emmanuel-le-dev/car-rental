package com.nayo.karenkou.a.emmanuel.car_rental_management.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nayo.karenkou.a.emmanuel.car_rental_management.api.EmployeeRestAPI;
import com.nayo.karenkou.a.emmanuel.car_rental_management.dtos.EmployeeDTO;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Employee;
import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.EmployeeType;
import com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceInterfaces.EmployeeServiceInterface;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class EmployeeRestController implements EmployeeRestAPI {

    private ModelMapper modelMapper;
    private EmployeeServiceInterface employeeServiceInterface;

    @Override
    public ResponseEntity<EmployeeDTO> createEmployee(EmployeeDTO employeeDTO) {
        // throw new UnsupportedOperationException("Unimplemented method 'createEmployee'");

        // Convert DTO to ENTITY
        Employee employeeRequest = modelMapper.map(employeeDTO, Employee.class);
        Employee employee = employeeServiceInterface.createEmployee(employeeRequest);

        // Convert ENTITY to DTO
        EmployeeDTO employeeResponse = modelMapper.map(employee, EmployeeDTO.class);

        return new ResponseEntity<EmployeeDTO>(employeeResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<EmployeeDTO> updateEmployee(EmployeeDTO employeeDTO, Long employee_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");

        // Convert DTO to ENTITY
        Employee employeeRequest = modelMapper.map(employeeDTO, Employee.class);
        Employee employee = employeeServiceInterface.updateEmployee(employeeRequest, employee_id);

        // Convert ENTITY to DTO
        EmployeeDTO employeeResponse = modelMapper.map(employee, EmployeeDTO.class);

        return ResponseEntity.ok().body(employeeResponse);

    }

    @Override
    public ResponseEntity<EmployeeDTO> findById(Long employee_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'findById'");
        
        Employee employee = employeeServiceInterface.findById(employee_id);

        // Convert ENTITY to DTO
        EmployeeDTO employeeResponse = modelMapper.map(employee, EmployeeDTO.class);
        
        return ResponseEntity.ok().body(employeeResponse);
    }

    @Override
    public ResponseEntity<String> deleteEmployee(Long employee_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
        employeeServiceInterface.deleteEmployee(employee_id);

        return new ResponseEntity<String>("Employee deleted successfuly", HttpStatus.OK);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        // throw new UnsupportedOperationException("Unimplemented method 'findAll'");

        return employeeServiceInterface.findAll()
            .stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findByNom(String nom) {
        // throw new UnsupportedOperationException("Unimplemented method 'findAllByNom'");

        return employeeServiceInterface.findByNom(nom)
            .stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findByPoste(String poste) {
        // throw new UnsupportedOperationException("Unimplemented method 'findAllByPoste'");

        return employeeServiceInterface.findByPoste(poste)
            .stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findByType(EmployeeType type) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByType'");

        return employeeServiceInterface.findByType(type)
            .stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class))
            .collect(Collectors.toList());
    }
  
}
