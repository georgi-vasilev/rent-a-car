package com.group.carrentalserver.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType {
    ADMIN("Admin"),
    TENANT("Tenant"),
    DEALER("Dealer");

    private final String type;
}
