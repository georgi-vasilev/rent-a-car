package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

    @Column
    private String country;

    @Column
    private String state;

    @Column
    private String city;

    @Column
    private String address;

    @ManyToOne
    private Car car;

    public Location() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountry(), getState(), getCity(), getAddress());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Location)) {
            return false;
        }
        return this.getId().equals(((Location) o).getId());
    }
}
