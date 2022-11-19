package com.group.carrentalserver.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Body {
    SUV("SUV"),
    HATCHBACK("Hatchback"),
    SEDAN("Sedan"),
    COUPE("Coupe"),
    MINIVAN("Minivan"),
    SPORT("Sport"),
    WAGON("Wagon");

    private final String body;
}
