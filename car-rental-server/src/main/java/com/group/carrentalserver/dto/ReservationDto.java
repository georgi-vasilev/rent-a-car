package com.group.carrentalserver.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ReservationDto extends BaseDto {
    private LocalDateTime creationDate;
    private LocalDateTime dueDate;
}
