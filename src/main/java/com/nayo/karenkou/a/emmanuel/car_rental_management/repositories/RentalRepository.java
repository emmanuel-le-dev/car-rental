package com.nayo.karenkou.a.emmanuel.car_rental_management.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Car;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Customer;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Employee;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Rental;
import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.RentalStatus;


@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findByDateDeLocation(LocalDate dateDeLocation);

    // Find all rental by employee
    List<Rental> findByEmployee(Employee employee);

    // Find all car rental
    List<Rental> findByCar(Car car);

    // Find all customer rental
    List<Rental> findByCustomer(Customer customer);

    List<Rental> findByStatus(RentalStatus status);
    
}
