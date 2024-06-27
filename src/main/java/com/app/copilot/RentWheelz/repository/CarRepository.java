package com.app.copilot.RentWheelz.repository;

import com.app.copilot.RentWheelz.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {
    // this is car repository interface
    // create a custom method to find car by status available findByStatusIgnoreCase()

// this method will return all the cars by their status
    List<Car> findByStatusIgnoreCase(String status);

}
