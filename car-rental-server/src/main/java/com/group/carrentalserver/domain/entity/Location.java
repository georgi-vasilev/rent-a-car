package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.entity.base.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
@Builder
@NoArgsConstructor
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
}
