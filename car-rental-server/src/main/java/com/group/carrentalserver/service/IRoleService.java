package com.group.carrentalserver.service;

import com.group.carrentalserver.domain.entity.Role;
import com.group.carrentalserver.domain.enumeration.RoleType;
import com.group.carrentalserver.service.base.IBaseService;

import java.util.Optional;

/**
 * Interface to a {@link Role} service.
 */
public interface IRoleService extends IBaseService<Role> {
    Optional<Role> findRoleByRoleType(RoleType roleType);
}
