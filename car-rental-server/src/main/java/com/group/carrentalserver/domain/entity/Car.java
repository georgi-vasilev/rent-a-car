package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.enumeration.Body;
import com.group.carrentalserver.domain.enumeration.Fuel;
import com.group.carrentalserver.domain.enumeration.SteeringWheelSide;
import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Car extends BaseEntity {

    @Column
    @Enumerated(value = EnumType.STRING)
    private Body body;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Fuel fuel;

    @Column
    @Enumerated(value = EnumType.STRING)
    private SteeringWheelSide steeringWheelSide;

    @Column
    private Integer hp;

    @Column
    private Integer seats;
}
