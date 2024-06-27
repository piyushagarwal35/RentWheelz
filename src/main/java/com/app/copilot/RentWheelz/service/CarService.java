package com.app.copilot.RentWheelz.service;

import com.app.copilot.RentWheelz.dto.CarDto;

import java.util.List;

public interface CarService {
    // this method will create the car in the database and return the car dto
    public CarDto createCar(CarDto carDto);

    // this method will return the car dto for the given car id
    public CarDto getCarById(String carId);
    // this method will update the car by id and return the updated car dto
    public CarDto updateCar(String carId, CarDto carDto);
    // this method will delete the car by id
    public void deleteCar(String carId);
    // this method will return all the cars
    public List<CarDto> getAllCars();

    // this method find cars with status available
    public List<CarDto> getAvailableCars();


}
