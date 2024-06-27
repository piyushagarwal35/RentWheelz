package com.app.copilot.RentWheelz.entity;

// this is reservation entity class having attributes bookingId,userEmail, carId, reservationDate,pickupDate, returnDate,noOfTravellers, status,car,img,total where bookingId , userEmail, carId should be unique and all fields should be required
// use lombok for all getter , setter and constructors
// make id as primary key and generate values automatically
// use @Entity annotation to make this class as entity
// use @Table annotation to give table name as reservation
// use @Data annotation to generate all getter and setter
// use @AllArgsConstructor annotation to generate all argument constructor
// use @NoArgsConstructor annotation to generate no argument constructor
// use @ToString annotation to generate toString method
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "reservation")
public class Reservation {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String bookingId;
    private String userEmail;
    private String carId;
    private Date reservationDate;
    private Date pickupDate;
    private Date returnDate;
    private Number noOfTravellers;
    private String status;
    private String car;
    private String img;
    private Number total;
}
