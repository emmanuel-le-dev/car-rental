package com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Employee;
import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.EmployeeType;
import com.nayo.karenkou.a.emmanuel.car_rental_management.repositories.EmployeeRepository;
import com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceInterfaces.EmployeeServiceInterface;
import com.nayo.karenkou.a.emmanuel.exceptions.DuplicateEntityException;
import com.nayo.karenkou.a.emmanuel.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        // throw new UnsupportedOperationException("Unimplemented method 'createEmployee'");
        // Check if the employee name is empty
        if (employee.getNom().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }

        // Check if the employee address is empty
        if (employee.getAdresse().isEmpty()) {
            throw new IllegalArgumentException("Employee address cannot be empty");
        }

        // Check if the employee age is valid
        if (employee.getAge() < 18) {
            throw new IllegalArgumentException("Employee age must be greater than or equal to 18");
        }

        // Check if the employee position is empty
        if (employee.getPoste().isEmpty()) {
            throw new IllegalArgumentException("Employee position cannot be empty");
        }

        // Check if the employee already exists
        Employee existingEmployee = employeeRepository.findByNomAndAdresse(employee.getNom(), employee.getAdresse());
        if (existingEmployee != null) {
            // Throw an exception because the employee already exists
            throw new DuplicateEntityException("An employee with the same name and address already exists");
        }

        
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long employee_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");

        // Check if the employee ID is null
        if (employee_id == null) {
            throw new IllegalArgumentException("Employee ID cannot be null");
        }

        // Check if the employee exists
        Employee existingEmployee = employeeRepository.findById(employee_id).orElseThrow(
            () -> new ResourceNotFoundException("Employee", "employee identifier", employee_id)
        );

        // Check if the employee name is empty
        if (employee.getNom().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }

        // Check if the employee address is empty
        if (employee.getAdresse().isEmpty()) {
            throw new IllegalArgumentException("Employee address cannot be empty");
        }

        // Check if the employee age is valid
        if (employee.getAge() < 18) {
            throw new IllegalArgumentException("Employee age must be greater than or equal to 18");
        }

        // Check if the employee position is empty
        if (employee.getPoste().isEmpty()) {
            throw new IllegalArgumentException("Employee position cannot be empty");
        }

        existingEmployee.setNom(employee.getNom());
        existingEmployee.setAdresse(employee.getAdresse());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setPoste(employee.getPoste());
        existingEmployee.setDateDePromotion(employee.getDateDePromotion());

        return existingEmployee;
    }

    @Override
    public Employee findById(Long employee_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'findById'");
        // Check if the employee ID is null
        if (employee_id == null) {
            throw new IllegalArgumentException("Employee ID cannot be null");
        }

        return employeeRepository.findById(employee_id).orElseThrow(
            () -> new ResourceNotFoundException("Employee", "employee identifier", employee_id)
        );
    }

    @Override
    public void deleteEmployee(Long employee_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");

        // Check if the employee ID is null
        if (employee_id == null) {
            throw new IllegalArgumentException("Employee ID cannot be null");
        }

        employeeRepository.findById(employee_id).orElseThrow(
            () -> new ResourceNotFoundException("Employee", "employee identifier", employee_id)
        );

        employeeRepository.deleteById(employee_id);
    }

    @Override
    public List<Employee> findAll() {
        // throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByNom(String nom) {
        // throw new UnsupportedOperationException("Unimplemented method 'findAllByNom'");

        // Check if the employee name is null or empty
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be null or empty");
        }

        return employeeRepository.findByNom(nom);
    }

    @Override
    public List<Employee> findByPoste(String poste) {
        // throw new UnsupportedOperationException("Unimplemented method 'findAllByPost'");

        // Check if the employee name is null or empty
        if (poste == null || poste.isEmpty()) {
            throw new IllegalArgumentException("Employee position cannot be null or empty");
        }
        return employeeRepository.findByPoste(poste);
    }

    @Override
    public List<Employee> findByType(EmployeeType type) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByType'");

        // Check if the employee type is null
        if (type == null) {
            throw new IllegalArgumentException("Employee type cannot be null");
        }

        return employeeRepository.findByType(type);
    }
    
}
