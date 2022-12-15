package com.group.carrentalserver.mapper;

import com.group.carrentalserver.domain.entity.Car;
import com.group.carrentalserver.dto.CarDto;
import org.mapstruct.Mapper;

@Mapper
public interface CarMapper {
    CarDto entityToDto(Car entity);
    Car dtoToEntity(CarDto dto);
}
