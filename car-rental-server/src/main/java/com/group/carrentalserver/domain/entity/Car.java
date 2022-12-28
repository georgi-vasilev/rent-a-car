package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.entity.base.BaseEntity;
import com.group.carrentalserver.domain.enumeration.Body;
import com.group.carrentalserver.domain.enumeration.CarStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Body body;

    @Column
    private Integer manufactureYear;

    @Column
    private String licenceNumber;

    @Column
    @Enumerated(value = EnumType.STRING)
    private CarStatus status;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Equipment equipment;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Insurance> insurances = new ArrayList<>();

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locations = new ArrayList<>();

    @ManyToOne
    private User user;

    public Car() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBody(), getBrand(), getModel(), getLicenceNumber(), getManufactureYear());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Car)) {
            return false;
        }
        return this.getId().equals(((Car) o).getId());
    }
}
