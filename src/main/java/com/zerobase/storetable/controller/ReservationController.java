package com.zerobase.storetable.controller;

import com.zerobase.storetable.dto.ReservationRequest;
import com.zerobase.storetable.entity.Reservation;
import com.zerobase.storetable.entity.User;
import com.zerobase.storetable.service.ReservationService;
import com.zerobase.storetable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private ReservationService reservationService;
    private UserService userService;

    @Autowired
    public ReservationController(ReservationService reservationService, UserService userService) {
        this.reservationService = reservationService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Reservation> registerReservation(@RequestParam("userid") String userid, @RequestBody ReservationRequest request) {
        if (userid == null || userid.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        User user = userService.getUserById(userid);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

//        request.setUserid(userid);
        Reservation reservation = reservationService.registerReservation(request, user);
        return ResponseEntity.ok(reservation);
    }
}
