package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.entity.base.BaseEntity;
import com.group.carrentalserver.domain.enumeration.Body;
import com.group.carrentalserver.domain.enumeration.Fuel;
import com.group.carrentalserver.domain.enumeration.Transmission;
import com.group.carrentalserver.domain.enumeration.VehicleStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table
@Entity
public class Car extends BaseEntity {

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Body body;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Fuel fuel;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Transmission transmission;

    @Column
    private Integer seats;

    @Column
    private Integer manufactureYear;

    @Column
    private String licenceNumber;

    @Column
    @Enumerated(value = EnumType.STRING)
    private VehicleStatus status;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Insurance> insurances = new ArrayList<>();

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locations = new ArrayList<>();

    @ManyToOne
    private Dealer dealer;
}
