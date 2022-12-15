package com.group.carrentalserver.domain.enumeration;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {
    ACTIVE("Active"),
    CANCELLED("Cancelled"),
    BLACKLISTED("Blacklisted"),
    CREATED("Created");

    private final String status;
}
