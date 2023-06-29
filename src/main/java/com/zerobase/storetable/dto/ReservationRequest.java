package com.zerobase.storetable.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
public class ReservationRequest {
    private String storename;
    private LocalDate reservationdate;
    private LocalTime reservationtime;
    private String phonenumber;
    private String username;
    private String userid;
}