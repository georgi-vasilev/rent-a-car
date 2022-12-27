package com.group.carrentalserver.service.impl;

import com.group.carrentalserver.domain.entity.Role;
import com.group.carrentalserver.domain.enumeration.RoleType;
import com.group.carrentalserver.repository.RoleRepository;
import com.group.carrentalserver.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findRoleByRoleType(RoleType roleType) {
        return roleRepository.findRoleByRoleType(roleType);
    }

    @Override
    public JpaRepository<Role, Integer> getJpaRepository() {
        return roleRepository;
    }

    @Override
    public Logger getLogger() {
        return log;
    }

    @Override
    public Class<?> getType() {
        return Role.class;
    }
}
