package com.app.copilot.RentWheelz.dto;

// this is reservation dto class
// it has attributes bookingId,userEmail, carId, reservationDate,pickupDate, returnDate,noOfTravellers, status,car,img,total
// use lombok for all getter , setter and constructors
// use @Data annotation to generate all getter and setter
// use @AllArgsConstructor annotation to generate all argument constructor
// use @NoArgsConstructor annotation to generate no argument constructor
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
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
