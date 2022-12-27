package com.group.carrentalserver.dto;

import com.group.carrentalserver.dto.enumeration.RegistrationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationEntryDto {

    private String email;

    private String username;

    private String password;

    private RegistrationType registrationType;
}
