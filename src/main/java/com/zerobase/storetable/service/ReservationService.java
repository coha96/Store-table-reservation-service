package com.zerobase.storetable.service;

import com.zerobase.storetable.dto.ReservationRequest;
import com.zerobase.storetable.entity.Reservation;
import com.zerobase.storetable.entity.User;
import com.zerobase.storetable.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation registerReservation(ReservationRequest request, User user) {
        Reservation reservation = new Reservation(request.getStorename(), request.getReservationdate(),
                request.getReservationtime(), request.getPhonenumber(), request.getUsername(), user);
        return reservationRepository.save(reservation);
    }

    public boolean isReservationTimeUnavailable(String storename, LocalDate reservationdate, LocalTime reservationtime) {
        List<Reservation> reservations = reservationRepository.findByStorenameAndReservationdateAndReservationtime(storename, reservationdate, reservationtime);
        return !reservations.isEmpty();
    }

    public Reservation getReservationById(Long ordernumber) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(ordernumber);
        return reservationOptional.orElse(null);
    }

    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public boolean hasCheckedIn(Long ordernumber) {
        Reservation reservation = getReservationById(ordernumber);
        return reservation != null && reservation.isCheckedin();
    }
}
