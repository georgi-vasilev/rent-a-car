package com.group.carrentalserver.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Transmission {
    MANUAL("Manual"),
    SEMI_AUTOMATIC("Semi-automatic"),
    AUTOMATIC("Automatic");

    private final String transmission;
}
