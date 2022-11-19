package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Table
@Entity
public class Reservation extends BaseEntity {

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime dueDate;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Tenant tenant;
}
