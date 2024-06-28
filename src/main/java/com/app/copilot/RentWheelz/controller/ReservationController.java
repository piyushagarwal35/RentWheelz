package com.app.copilot.RentWheelz.controller;

// this is reservation controller

import com.app.copilot.RentWheelz.dto.ReservationDto;
import com.app.copilot.RentWheelz.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationDto reservationDto) {
        ReservationDto createdReservation = reservationService.createReservation(reservationDto);
        return ResponseEntity.ok(createdReservation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> getReservation(@PathVariable String id) {
        ReservationDto reservation = reservationService.getReservation(id);
        return ResponseEntity.ok(reservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable String id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        List<ReservationDto> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/user/{userEmail}")
    public ResponseEntity<List<ReservationDto>> getReservationsByUserId(@PathVariable String userEmail) {
        List<ReservationDto> reservations = reservationService.getReservationsByUserId(userEmail);
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/vehicle/{carId}")
    public ResponseEntity<List<ReservationDto>> getReservationsByVehicleId(@PathVariable String carId) {
        List<ReservationDto> reservations = reservationService.getReservationsByVehicleId(carId);
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/user/{userEmail}/vehicle/{carId}")
    public ResponseEntity<List<ReservationDto>> getReservationsByUserIdAndVehicleId(@PathVariable String userEmail, @PathVariable String carId) {
        List<ReservationDto> reservations = reservationService.getReservationsByUserIdAndVehicleId(userEmail, carId);
        return ResponseEntity.ok(reservations);
    }

}
