package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table
@Entity
public class Equipment extends BaseEntity {

    @Column
    private Boolean hasAirConditioning;
}
