package com.group.carrentalserver.repository;

import com.group.carrentalserver.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    Optional<Reservation> findById(Integer integer);
}
