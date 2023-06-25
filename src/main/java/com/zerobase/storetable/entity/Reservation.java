package com.zerobase.storetable.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordernumber;

    private String storename;
    private LocalDate reservationdate;
    private LocalTime reservationtime;
    private String phonenumber;
    private String username;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public Reservation() {
    }

    public Reservation(String storename, LocalDate reservationdate, LocalTime reservationtime, String phonenumber, String username, User user) {
        this.storename = storename;
        this.reservationdate = reservationdate;
        this.reservationtime = reservationtime;
        this.phonenumber = phonenumber;
        this.username = username;
        this.user = user;
    }
}
