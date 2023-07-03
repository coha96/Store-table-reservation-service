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

    /**
     * 예약을 등록합니다.
     *
     * @param request 예약 요청 정보
     * @param user    예약한 사용자 정보
     * @return 등록된 예약
     */
    public Reservation registerReservation(ReservationRequest request, User user) {
        Reservation reservation = new Reservation(request.getStorename(), request.getReservationdate(),
                request.getReservationtime(), request.getPhonenumber(), request.getUsername(), user);
        return reservationRepository.save(reservation);
    }

    /**
     * 특정 시간에 예약이 가능한지 확인합니다.
     *
     * @param storename       매장 이름
     * @param reservationdate 예약 날짜
     * @param reservationtime 예약 시간
     * @return 예약 가능 여부
     */
    public boolean isReservationTimeUnavailable(String storename, LocalDate reservationdate, LocalTime reservationtime) {
        List<Reservation> reservations = reservationRepository.findByStorenameAndReservationdateAndReservationtime(storename, reservationdate, reservationtime);
        return !reservations.isEmpty();
    }

    /**
     * 예약 번호로 예약을 조회합니다.
     *
     * @param ordernumber 예약 번호
     * @return 예약 정보
     */
    public Reservation getReservationById(Long ordernumber) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(ordernumber);
        return reservationOptional.orElse(null);
    }

    /**
     * 예약 정보를 저장합니다.
     *
     * @param reservation 저장할 예약 정보
     */
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    /**
     * 예약이 체크인되었는지 확인합니다. (즉, 도착 확인)
     *
     * @param ordernumber 예약 번호
     * @return 체크인 여부
     */
    public boolean hasCheckedIn(Long ordernumber) {
        Reservation reservation = getReservationById(ordernumber);
        return reservation != null && reservation.isCheckedin();
    }
}