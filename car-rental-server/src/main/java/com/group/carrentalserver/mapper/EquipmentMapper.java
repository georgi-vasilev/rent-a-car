package com.group.carrentalserver.mapper;

import com.group.carrentalserver.domain.entity.Equipment;
import com.group.carrentalserver.dto.EquipmentDto;
import org.mapstruct.Mapper;

@Mapper
public interface EquipmentMapper {
    EquipmentDto entityToDto(Equipment entity);
    Equipment dtoToEntity(EquipmentDto dto);
}
