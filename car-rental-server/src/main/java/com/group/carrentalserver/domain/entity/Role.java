package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.enumeration.RoleType;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table
@Entity
public class Role extends BaseEntity {

    @Column
    @Enumerated(value = EnumType.STRING)
    private RoleType roleType;

    @Column
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
