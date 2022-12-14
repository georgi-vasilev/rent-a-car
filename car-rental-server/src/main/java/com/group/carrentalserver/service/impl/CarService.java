package com.group.carrentalserver.service.impl;

import com.group.carrentalserver.domain.entity.Car;
import com.group.carrentalserver.repository.CarRepository;
import com.group.carrentalserver.service.ICarService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarService implements ICarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public JpaRepository<Car, Integer> getJpaRepository() {
        return carRepository;
    }

    @Override
    public Logger getLogger() {
        return log;
    }

    @Override
    public Class<?> getType() {
        return Car.class;
    }

}
