package com.group.carrentalserver.Mapper;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.dto.RegistrationDto;
import org.mapstruct.Mapper;

@Mapper
public interface RegistrationMapper {
    RegistrationDto registrationToRegistrationDto(User user);
}
