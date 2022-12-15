package com.group.carrentalserver.dto;

import com.group.carrentalserver.domain.enumeration.Body;
import com.group.carrentalserver.domain.enumeration.CarStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CarDto extends BaseDto {
    private String brand;
    private String model;
    private Body body;
    private Integer manufactureYear;
    private String licenceNumber;
    private CarStatus status;
    private EquipmentDto equipment;
    private DealerDto dealer;
}
