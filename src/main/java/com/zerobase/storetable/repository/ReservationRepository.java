package com.zerobase.storetable.repository;

import com.zerobase.storetable.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByStorenameAndReservationdateAndReservationtime(String storename, LocalDate reservationdate, LocalTime reservationtime);
}
