package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Insurance extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    @Column
    private String company;

    @Column
    private LocalDateTime validFrom;

    @Column
    private LocalDateTime validTo;
}
