package com.zerobase.storetable.controller;

import com.zerobase.storetable.dto.ReservationRequest;
import com.zerobase.storetable.entity.Reservation;
import com.zerobase.storetable.entity.User;
import com.zerobase.storetable.service.ReservationService;
import com.zerobase.storetable.service.StoreService;
import com.zerobase.storetable.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final StoreService storeService;
    private final UserService userService;

    public ReservationController(ReservationService reservationService, StoreService storeService, UserService userService) {
        this.reservationService = reservationService;
        this.storeService = storeService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerReservation(@RequestParam("userid") String userid, @RequestBody ReservationRequest request) {
        if (userid == null || userid.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        User user = userService.getUserById(userid);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        String storename = request.getStorename();
        if (!storeService.isStoreRegistered(storename)) {
            return ResponseEntity.badRequest().body("등록된 매장이 아닙니다.");
        }

        if (reservationService.isReservationTimeUnavailable(storename, request.getReservationdate(), request.getReservationtime())) {
            return ResponseEntity.badRequest().body("해당 시간에 예약이 이미 존재합니다.");
        }

        Reservation reservation = reservationService.registerReservation(request, user);
        return ResponseEntity.ok("예약이 완료되었습니다.");
    }

    @PostMapping("/check-in")
    public ResponseEntity<?> checkInReservation(@RequestParam("ordernumber") Long ordernumber) {
        Reservation reservation = reservationService.getReservationById(ordernumber);
        if (reservation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("예약 정보가 없습니다.");
        }

        LocalDateTime reservationDateTime = LocalDateTime.of(reservation.getReservationdate(), reservation.getReservationtime());
        LocalDateTime currentDateTime = LocalDateTime.now();

        if (currentDateTime.isBefore(reservationDateTime.minusMinutes(10))) {
            return ResponseEntity.badRequest().body("예약 시간 10분 전부터 도착 확인이 가능합니다.");
        }

        reservation.setCheckedin(true);
        reservationService.saveReservation(reservation);

        return ResponseEntity.ok("도착 확인이 완료되었습니다.");
    }
}
