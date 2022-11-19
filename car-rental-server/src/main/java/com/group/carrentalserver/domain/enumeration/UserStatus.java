package com.group.carrentalserver.domain.enumeration;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {
    ACTIVE("Active"),
    CANCELLED("Cancelled"),
    BLACKLISTED("Blacklisted"),
    NONE("None");

    private final String status;
}
