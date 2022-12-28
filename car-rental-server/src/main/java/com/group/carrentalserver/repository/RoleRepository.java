package com.group.carrentalserver.repository;

import com.group.carrentalserver.domain.entity.Role;
import com.group.carrentalserver.domain.enumeration.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findRoleByRoleType(RoleType roleType);
}
