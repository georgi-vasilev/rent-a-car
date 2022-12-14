package com.group.carrentalserver.repository;

import com.group.carrentalserver.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository  extends JpaRepository<Car,Integer> {

    Optional<Car> findById(Integer integer);
}
