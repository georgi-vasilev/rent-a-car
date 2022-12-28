package com.group.carrentalserver.service;

import com.group.carrentalserver.domain.entity.Role;
import com.group.carrentalserver.domain.enumeration.RoleType;
import com.group.carrentalserver.service.base.BaseService;

import java.util.Optional;

/**
 * Interface to a {@link Role} service.
 */
public interface RoleService extends BaseService<Role> {
    Optional<Role> findRoleByRoleType(RoleType roleType);
}
