package com.group.carrentalserver.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SteeringWheelSide {
    LEFT("Left"),
    RIGHT("Right");

    private final String side;
}
