package com.app.copilot.RentWheelz.service.impl;

import com.app.copilot.RentWheelz.dto.CarDto;
import com.app.copilot.RentWheelz.entity.Car;
import com.app.copilot.RentWheelz.exception.CarNotFoundException;
import com.app.copilot.RentWheelz.repository.CarRepository;
import com.app.copilot.RentWheelz.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// this is service layer of car service

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public CarDto createCar(CarDto carDto) {

        Car car = convertToEntity(carDto);
        Car savedCar = carRepository.save(car);
        return convertToDto(savedCar);

    }

    @Override
    public CarDto getCarById(String carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + carId));
        return convertToDto(car);
    }

    @Override
    public CarDto updateCar(String carId, CarDto carDto) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + carId));
        // Update car details here
        car.setCarModel(carDto.getCarModel());
        car.setRegistrationNumber(carDto.getRegistrationNumber());
        car.setStatus(carDto.getStatus());
        car.setBrand(carDto.getBrand());
        car.setPricePerHour(carDto.getPricePerHour());
        car.setThumbnail(carDto.getThumbnail());
        Car updatedCar = carRepository.save(car);
        return convertToDto(updatedCar);
    }

    @Override
    public void deleteCar(String carId) {
        if (!carRepository.existsById(carId)) {
            throw new CarNotFoundException("Car not found with id: " + carId);
        }
        carRepository.deleteById(carId);
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getAvailableCars() {
        // this method will return all the avaialble cars by their status = AVAILABLE ignore case
        List<Car> cars = carRepository.findByStatusIgnoreCase("AVAILABLE");
        return cars.stream().map(this::convertToDto).collect(Collectors.toList());

    }

    private CarDto convertToDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setCarId(car.getCarId());
        carDto.setCarModel(car.getCarModel());
        carDto.setRegistrationNumber(car.getRegistrationNumber());
        carDto.setStatus(car.getStatus());
        carDto.setBrand(car.getBrand());
        carDto.setPricePerHour(car.getPricePerHour());
        carDto.setThumbnail(car.getThumbnail());
        return carDto;
    }

    private Car convertToEntity(CarDto carDto) {
        Car car = new Car();
        car.setCarId(carDto.getCarId());
        car.setCarModel(carDto.getCarModel());
        car.setRegistrationNumber(carDto.getRegistrationNumber());
        car.setStatus(carDto.getStatus());
        car.setBrand(carDto.getBrand());
        car.setPricePerHour(carDto.getPricePerHour());
        car.setThumbnail(carDto.getThumbnail());
        return car;
    }
}
