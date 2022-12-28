package com.group.carrentalserver.dto;

import com.group.carrentalserver.annotation.ValidEmail;
import com.group.carrentalserver.dto.enumeration.RegistrationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationEntryDto {

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    private RegistrationType registrationType;
}
