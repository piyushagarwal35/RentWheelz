package com.app.copilot.RentWheelz.repository;

import com.app.copilot.RentWheelz.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
