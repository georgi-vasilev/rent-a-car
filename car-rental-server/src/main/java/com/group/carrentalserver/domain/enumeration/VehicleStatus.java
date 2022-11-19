package com.group.carrentalserver.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VehicleStatus {
    AVAILABLE("Available"),
    RESERVED("Reserved"),
    LOANED("Loaned");

    private final String status;
}
