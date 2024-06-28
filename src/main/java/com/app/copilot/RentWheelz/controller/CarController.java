package com.app.copilot.RentWheelz.controller;
 //this is car controller class
import com.app.copilot.RentWheelz.dto.CarDto;
import com.app.copilot.RentWheelz.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    //this method will create car
//this method will take car object as input
    //this method will return car object
    //this method will have post mapping
    @PostMapping
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto) {
        CarDto createdCar = carService.createCar(carDto);
        return ResponseEntity.ok(createdCar);
    }

    //this method will get car by id
//this method will take car id as input
    //this method will return car object
    //this method will have get mapping
    @GetMapping("/{carId}")
    public ResponseEntity<CarDto> getCarById(@PathVariable String carId) {
        CarDto car = carService.getCarById(carId);
        return ResponseEntity.ok(car);
    }

    //this method will update car
    //this method will take car object as input
    //this method will return car object
    //this method will have put mapping
    @PutMapping
    public ResponseEntity<CarDto> updateCar(@RequestBody CarDto carDto) {
        CarDto updatedCar = carService.updateCar(carDto.getCarId(),carDto);
        return ResponseEntity.ok(updatedCar);
    }

    //this method will delete car by id
    //this method will take car id as input
    //this method will return string
    @DeleteMapping("/{carId}")
    public ResponseEntity<String> deleteCar(@PathVariable String carId) {
        carService.deleteCar(carId);
        return ResponseEntity.ok("Car deleted successfully");
    }

    //this method will get all cars
    //this method will return list of car objects
    //this method will have get mapping
    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    //this method will get available cars
    //this method will return list of car objects
    //this method will have get mapping
    @GetMapping("/available")
    public ResponseEntity<List<CarDto>> getAvailableCars() {
        List<CarDto> cars = carService.getAvailableCars();
        return ResponseEntity.ok(cars);
    }

}
