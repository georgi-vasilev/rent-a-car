package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.entity.base.BaseEntity;
import com.group.carrentalserver.domain.enumeration.RoleType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table
@Entity
@Builder
@NoArgsConstructor
public class Role extends BaseEntity {

    @Column
    @Enumerated(value = EnumType.STRING)
    private RoleType roleType;

    @Column
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
