package com.group.carrentalserver.dto;

import com.group.carrentalserver.domain.enumeration.Fuel;
import com.group.carrentalserver.domain.enumeration.Transmission;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class EquipmentDto extends BaseDto {
    private Boolean hasAirConditioning;
    private Boolean hasNavigation;
    private Fuel fuel;
    private Transmission transmission;
    private Integer seats;
}
