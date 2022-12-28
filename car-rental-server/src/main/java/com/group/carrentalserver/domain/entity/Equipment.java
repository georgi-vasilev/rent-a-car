package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.entity.base.BaseEntity;
import com.group.carrentalserver.domain.enumeration.Fuel;
import com.group.carrentalserver.domain.enumeration.Transmission;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "equipments")
public class Equipment extends BaseEntity {

    @Column
    private Boolean hasAirConditioning;

    @Column
    private Boolean hasNavigation;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Fuel fuel;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Transmission transmission;

    @Column
    private Integer seats;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    public Equipment() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHasNavigation(), getHasNavigation(), getFuel(), getTransmission(), getSeats());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Equipment)) {
            return false;
        }
        return this.getId().equals(((Equipment) o).getId());
    }
}
