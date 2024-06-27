package com.app.copilot.RentWheelz.service;

import com.app.copilot.RentWheelz.dto.ReservationDto;

import java.util.List;

public interface ReservationService {

// this method will create the reservation in the database and return the reservation dto
 public ReservationDto createReservation(ReservationDto reservationDto);

// this method will return the reservation by id
    public ReservationDto getReservation(Long id);
    // this method will update the reservation by id and return the updated reservation dto
   // public ReservationDto updateReservation(Long id, ReservationDto reservationDto);
    // this method will cancle or delete booking by id
    public void deleteReservation(Long id);
    // this method will return all the reservations
    public List<ReservationDto> getAllReservations();
    // this method will return all the reservation by user id

    // this method will return all the avaialble cars
    public List<ReservationDto> getAvailableCars();
    public List<ReservationDto> getReservationsByUserId(Long userId);
    // this method will return all the reservation by vehicle id
    public List<ReservationDto> getReservationsByVehicleId(Long vehicleId);
    // this method will return all the reservation by user id and vehicle id
    public List<ReservationDto> getReservationsByUserIdAndVehicleId(Long userId, Long vehicleId);





}
