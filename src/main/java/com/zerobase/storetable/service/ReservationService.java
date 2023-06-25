package com.zerobase.storetable.service;

import com.zerobase.storetable.dto.ReservationRequest;
import com.zerobase.storetable.entity.Reservation;
import com.zerobase.storetable.entity.User;
import com.zerobase.storetable.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

//    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation registerReservation(ReservationRequest request, User user) {
        Reservation reservation = new Reservation(request.getStorename(),request.getReservationdate(),
                request.getReservationtime(), request.getPhonenumber(), request.getUsername(), user);
        return reservationRepository.save(reservation);


//    public Reservation createReservation(ReservationRequest reservationRequest) {
//        Reservation reservation = new Reservation();
//        reservation.setStorename(reservationRequest.getStorename());
//        reservation.setReservationdate(reservationRequest.getReservationdate());
//        reservation.setReservationtime(reservationRequest.getReservationtime());
//        reservation.setPhonenumber(reservationRequest.getPhonenumber());
//        reservation.setUsername(reservationRequest.getUsername());
//        reservation.setUserid(reservationRequest.getUserid());
//
//        return reservationRepository.save(reservation);
    }
}
