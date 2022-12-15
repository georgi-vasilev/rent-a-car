package com.group.carrentalserver.mapper;

import com.group.carrentalserver.domain.entity.Role;
import com.group.carrentalserver.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    RoleDto entityToDto(Role entity);
    Role dtoToEntity(RoleDto dto);
}
