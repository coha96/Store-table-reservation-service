package com.zerobase.storetable.repository;

import com.zerobase.storetable.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    /**
     * 매장 이름, 예약 날짜, 예약 시간을 기준으로 예약을 조회합니다.
     *
     * @param storename       매장 이름
     * @param reservationdate 예약 날짜
     * @param reservationtime 예약 시간
     * @return 예약 목록
     */
    List<Reservation> findByStorenameAndReservationdateAndReservationtime(String storename, LocalDate reservationdate, LocalTime reservationtime);
}
