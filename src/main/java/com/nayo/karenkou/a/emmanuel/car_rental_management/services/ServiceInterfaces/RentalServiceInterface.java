package com.nayo.karenkou.a.emmanuel.car_rental_management.services.ServiceInterfaces;

import java.time.LocalDate;
import java.util.List;

import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Car;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Customer;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Employee;
import com.nayo.karenkou.a.emmanuel.car_rental_management.entities.Rental;
import com.nayo.karenkou.a.emmanuel.car_rental_management.enums.RentalStatus;

public interface RentalServiceInterface {

    Rental createRent(Rental rent);

    Rental updateRental(Rental rent, Long rent_id);

    Rental findById(Long rent_id);

    void deleteRent(Long rent_id);

    List<Rental> findAll();

    List<Rental> findByDateDeLocation(LocalDate dateDeLocation);

    List<Rental> findByEmployee(Employee employee);

    List<Rental> findByCustomer(Customer customer);

    List<Rental> findByCar(Car car);

    List<Rental> findByStatus(RentalStatus status);
    
}
