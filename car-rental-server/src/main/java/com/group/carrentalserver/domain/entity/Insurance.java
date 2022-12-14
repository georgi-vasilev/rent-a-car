package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.entity.base.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table
@Entity
@Builder
@NoArgsConstructor
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
