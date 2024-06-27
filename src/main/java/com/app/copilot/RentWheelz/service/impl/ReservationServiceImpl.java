package com.app.copilot.RentWheelz.service.impl;

import com.app.copilot.RentWheelz.dto.ReservationDto;
import com.app.copilot.RentWheelz.entity.Reservation;
import com.app.copilot.RentWheelz.exception.ReservationNotFoundException;
import com.app.copilot.RentWheelz.repository.CarRepository;
import com.app.copilot.RentWheelz.repository.ReservationRepository;
import com.app.copilot.RentWheelz.service.CarService;
import com.app.copilot.RentWheelz.service.ReservationService;

// this is reservation service implementation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CarService carService;
// this method will create the reservation in the database and return the reservation dto

    @Override
    public ReservationDto createReservation(ReservationDto reservationDto) {
        Reservation reservation = convertToEntity(reservationDto);
        Reservation savedReservation = reservationRepository.save(reservation);
        return convertToDto(savedReservation);
    }

    @Override
    public ReservationDto getReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation not found with id: " + id));
        return convertToDto(reservation);
    }

    // this method will cancle or delete booking by id
    @Override
    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new ReservationNotFoundException("Reservation not found with id: " + id);
        }
        reservationRepository.deleteById(id);
    }

    // this method will return all the reservations
    @Override
    public List<ReservationDto> getAllReservations() {
        List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();
        return reservations.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // this method will return all the avaialble cars by their status
    @Override
    public List<ReservationDto> getAvailableCars() {
        // Assuming CarRepository is available and has a method to find cars by status
        // This is a placeholder logic. Implement according to your application's requirements
        return carService.getAvailableCars().stream()
                .map(this::convertToReservationDto) // Assuming you have a method to convert Car to ReservationDto
                .collect(Collectors.toList());
    }

    // this method will return all the reservation by user id
    public List<ReservationDto> getReservationsByUserId(Long userId) {
        return null;
    }

    // this method will return all the reservation by vehicle id
    public List<ReservationDto> getReservationsByVehicleId(Long vehicleId) {
        return null;
    }

    // this method will return all the reservation by user id and vehicle id
    public List<ReservationDto> getReservationsByUserIdAndVehicleId(Long userId, Long vehicleId) {
        return null;
    }

    public ReservationDto convertToDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setBookingId(reservation.getBookingId());
        reservationDto.setUserEmail(reservation.getUserEmail());
        reservationDto.setCarId(reservation.getCarId());
        reservationDto.setPickupDate(reservation.getPickupDate());
        reservationDto.setReturnDate(reservation.getReturnDate());
        reservationDto.setTotal(reservation.getTotal());
        reservationDto.setStatus(reservation.getStatus());
        return reservationDto;
    }

    public Reservation convertToEntity(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        reservation.setBookingId(reservationDto.getBookingId());
        reservation.setUserEmail(reservationDto.getUserEmail());
        reservation.setCarId(reservationDto.getCarId());
        reservation.setPickupDate(reservationDto.getPickupDate());
        reservation.setReturnDate(reservationDto.getReturnDate());
        reservation.setTotal(reservationDto.getTotal());
        reservation.setStatus(reservationDto.getStatus());
        return reservation;
    }

}
