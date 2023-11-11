package com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Car;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Customer;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Employee;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Rental;
import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.RentalStatus;
import com.nayo.karenkou.a.emmanuel.car_rental_management.exceptions.InvalidRentalException;
import com.nayo.karenkou.a.emmanuel.car_rental_management.exceptions.ResourceNotFoundException;
import com.nayo.karenkou.a.emmanuel.car_rental_management.repositories.CarRepository;
import com.nayo.karenkou.a.emmanuel.car_rental_management.repositories.CustomerRepository;
import com.nayo.karenkou.a.emmanuel.car_rental_management.repositories.EmployeeRepository;
import com.nayo.karenkou.a.emmanuel.car_rental_management.repositories.RentalRepository;
import com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceInterfaces.RentalServiceInterface;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RentalServiceImpl implements RentalServiceInterface {

    private RentalRepository rentalRepository;
    private EmployeeRepository employeeRepository;
    private CustomerRepository customerRepository;
    private CarRepository carRepository;

    @Override
    public Rental createRent(Rental rent) {
        // throw new UnsupportedOperationException("Unimplemented method 'createRent'");

        // Check if the rental start date is null
        if (rent.getDateDeLocation() == null) {
            throw new IllegalArgumentException("Rental start date cannot be null");
        }

        // Check if the rental duration is null or less than one day
        if (rent.getDureeDeLocation() == null || rent.getDureeDeLocation() < 1) {
            throw new IllegalArgumentException("Rental duration must be greater than or equal to one day");
        }

        // Check if the employee is null
        if (rent.getEmployee() == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }

        // Check if the customer is null
        if (rent.getCustomer() == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        Employee existingEmployee = employeeRepository.findByNomAndAdresse(rent.getEmployee().getNom(), rent.getEmployee().getAdresse());
        if (existingEmployee == null) {
            throw new InvalidRentalException("Employee does not exist");
        }
        
        // Check if the customer exists
        Customer existingCustomer = customerRepository.findByNumeroCIN(rent.getCustomer().getNumeroCIN());
        if (existingCustomer == null) {
            throw new InvalidRentalException("Customer does not exist");
        }

        // Check if the car exists
        Car existingCar = carRepository.findByNumeroImmatriculation(rent.getCar().getNumeroImmatriculation());
        if (existingCar == null) {
            throw new InvalidRentalException("Car does not exist");
        }

        rent.setEmployee(existingEmployee);
        rent.setCustomer(existingCustomer);
        rent.setCar(existingCar);

        // Save the rental to the database
        return rentalRepository.save(rent);
    }

    @Override
    public Rental updateRental(Rental rent, Long rent_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'updateRental'");
        Rental existingRent = rentalRepository.findById(rent_id).orElseThrow(
            () -> new ResourceNotFoundException("Rental", "id", rent_id)
        );

        existingRent.setDateDeLocation(rent.getDateDeLocation());
        existingRent.setDureeDeLocation(rent.getDureeDeLocation());
        existingRent.setEmployee(rent.getEmployee());
        existingRent.setCustomer(rent.getCustomer());

        return existingRent;
    }

    @Override
    public Rental findById(Long rent_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'findById'");
        return rentalRepository.findById(rent_id).orElseThrow(
            () -> new ResourceNotFoundException("Rental", "id", rent_id)
        );
    }

    @Override
    public void deleteRent(Long rent_id) {
        // throw new UnsupportedOperationException("Unimplemented method 'deleteRent'");
        rentalRepository.findById(rent_id).orElseThrow(
            () -> new ResourceNotFoundException("Rental", "id", rent_id)
        );

        rentalRepository.deleteById(rent_id);
    }

    @Override
    public List<Rental> findAll() {
        // throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        return rentalRepository.findAll();
    }

    @Override
    public List<Rental> findByDateDeLocation(LocalDate dateDeLocation) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByDateDeLocation'");
        return rentalRepository.findByDateDeLocation(dateDeLocation);
    }

    @Override
    public List<Rental> findByEmployee(Employee employee) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByEmployee'");

        return rentalRepository.findByEmployee(employee);
    }

    @Override
    public List<Rental> findByCustomer(Customer customer) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByCustomer'");
        return rentalRepository.findByCustomer(customer);
    }

    @Override
    public List<Rental> findByCar(Car car) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByCar'");
        return rentalRepository.findByCar(car);
    }

    @Override
    public List<Rental> findByStatus(RentalStatus status) {
        // throw new UnsupportedOperationException("Unimplemented method 'findByStatus'");
        return rentalRepository.findByStatus(status);
    }
    
}
