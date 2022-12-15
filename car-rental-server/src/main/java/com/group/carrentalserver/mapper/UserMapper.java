package com.group.carrentalserver.mapper;


import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto entityToDto(User entity);
    User dtoToEntity(UserDto dto);
}


