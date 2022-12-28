package com.group.carrentalserver.domain.entity.base;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @SequenceGenerator(name = "base_entity_pk_sequence",
            sequenceName = "base_entity_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "base_entity_pk_sequence")
    private Integer id;
}
