package com.group.carrentalserver.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class BaseDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
}
