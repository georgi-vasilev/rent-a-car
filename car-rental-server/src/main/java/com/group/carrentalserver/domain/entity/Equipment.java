package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.entity.base.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table
@Entity
@Builder
@NoArgsConstructor
public class Equipment extends BaseEntity {

    @Column
    private Boolean hasAirConditioning;
}
