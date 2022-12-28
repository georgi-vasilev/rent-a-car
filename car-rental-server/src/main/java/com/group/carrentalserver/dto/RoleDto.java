package com.group.carrentalserver.dto;

import com.group.carrentalserver.domain.enumeration.RoleType;
import lombok.Data;

@Data
public class RoleDto {
    private Integer id;
    private RoleType roleType;
}
