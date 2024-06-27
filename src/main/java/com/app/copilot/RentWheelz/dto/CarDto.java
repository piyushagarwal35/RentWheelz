package com.app.copilot.RentWheelz.dto;

 // this is car dto class
    // it has attributes id, name, model, price and type
    // use lombok for all getter , setter and constructors
    // use @Data annotation to generate all getter and setter
    // use @AllArgsConstructor annotation to generate all argument constructor
    // use @NoArgsConstructor annotation to generate no argument constructor
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String carId;
    private String carModel;
    private String registrationNumber;
    private String status;
    private String brand;
    private Number pricePerHour;
    private String thumbnail;


}
