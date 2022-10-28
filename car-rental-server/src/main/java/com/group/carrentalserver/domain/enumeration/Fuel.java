package com.group.carrentalserver.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Fuel {
    ELECTRIC("Electric"),
    DIESEL("Diesel"),
    PETROL("Petrol"),
    HYBRID("Hybrid"),
    GAS("Gas");

    private final String type;
}
