package com.group.carrentalserver.dto.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegistrationType {
    DEALER("Dealer"),
    TENANT("Tenant"),
    BOTH("Both");

    private final String type;
}
