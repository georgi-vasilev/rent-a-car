package com.group.carrentalserver.Mapper;

import com.group.carrentalserver.domain.entity.Tenant;
import org.mapstruct.Mapper;

@Mapper
public interface TenantMapper {
    TenantMapper tenantToTenantDto(Tenant tenant);
}
