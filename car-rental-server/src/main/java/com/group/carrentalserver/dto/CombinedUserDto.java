package com.group.carrentalserver.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CombinedUserDto extends UserDto {
    private List<CarDto> cars = new ArrayList<>();
    private List<ReservationDto> reservations = new ArrayList<>();
}
