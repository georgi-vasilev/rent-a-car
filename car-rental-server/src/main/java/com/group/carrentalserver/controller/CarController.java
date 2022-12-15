package com.group.carrentalserver.controller;

import com.group.carrentalserver.domain.entity.Car;
import com.group.carrentalserver.dto.CarDto;
import com.group.carrentalserver.exception.BadRequestException;
import com.group.carrentalserver.mapper.CarMapper;
import com.group.carrentalserver.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private static final String ENTITY_NAME = Car.class.getSimpleName();

    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Integer id) {
        log.debug("REST request to fetch Car entity by ID: {} ", id);

        Optional<Car> optionalCar = carService.findOneById(id);

        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            CarDto result = carMapper.entityToDto(car);

            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll() {
        log.debug("REST request to fetch all Car entities!");

        List<CarDto> result = carService.findAll()
                .stream()
                .map(carMapper::entityToDto)
                .toList();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll(Pageable pageable) {
        log.debug("REST request to fetch all Car entities by a pageable criteria!");

        List<CarDto> result = carService.findAll(pageable).getContent().stream()
                .map(carMapper::entityToDto)
                .toList();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto dto) {
        log.debug("REST request to save a Car: {}!", dto);
        if (dto.getId() != null) {
            throw new BadRequestException(ENTITY_NAME);
        }
        Car car = carMapper.dtoToEntity(dto);
        car = carService.save(car);
        CarDto result = carMapper.entityToDto(car);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteCar(@PathVariable Integer id) {
        log.debug("REST request to delete a Car with ID: {}!", id);

        Optional<Car> optionalCar = carService.findOneById(id);
        if (optionalCar.isPresent()) {
            carService.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
