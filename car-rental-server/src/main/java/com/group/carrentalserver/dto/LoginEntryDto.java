package com.group.carrentalserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginEntryDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
