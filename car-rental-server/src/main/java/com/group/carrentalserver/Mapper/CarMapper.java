package com.group.carrentalserver.Mapper;

import com.group.carrentalserver.domain.entity.Car;
import org.mapstruct.Mapper;

@Mapper
public interface CarMapper {
    CarMapper carToCarDto(Car car);
}
