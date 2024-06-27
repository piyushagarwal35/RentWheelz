package com.app.copilot.RentWheelz.entity;

// this is car entity class having attributes carId, carModel, registrationNumber, status, brand, pricePerHour,thumbnail where carid and registration number should be unique and all fields should be required
// use lombok for all getter , setter and constructors
// make id as primary key and generate values automatically
// use @Entity annotation to make this class as entity
// use @Table annotation to give table name as car
// use @Data annotation to generate all getter and setter
// use @AllArgsConstructor annotation to generate all argument constructor
// use @NoArgsConstructor annotation to generate no argument constructor
// use @ToString annotation to generate toString method
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "car")
public class Car {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String carId;
    private String carModel;
    private String registrationNumber;
    private String status;
    private String brand;
    private Number pricePerHour;
    private String thumbnail;
}
