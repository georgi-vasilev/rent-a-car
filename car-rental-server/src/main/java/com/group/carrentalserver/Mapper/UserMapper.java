package com.group.carrentalserver.Mapper;


import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {

//    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto userToUserDto(User user);
}


