package com.app.copilot.RentWheelz.repository;

import com.app.copilot.RentWheelz.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import list
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

    // this is reservation repository interface
   // create a custom method to find reservation by UserId
    List<Reservation> findByUserId(String userEmail);
    //create a custom method to find reservation by carId
    List<Reservation> findByCarId(String carId);
    //create a custom query to find reservation by userId and carId

    @Query("SELECT r FROM Reservation r WHERE r.userEmail = :userEmail AND r.carId = :carId")
    List<Reservation> findReservationsByUserIdAndCarId(@Param("userId") String userEmail, @Param("carId") String carId);




}
