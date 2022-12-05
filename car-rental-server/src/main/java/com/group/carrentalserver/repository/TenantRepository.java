package com.group.carrentalserver.repository;

import com.group.carrentalserver.domain.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantRepository  extends JpaRepository<Tenant,Integer> {

    Optional<Tenant> findById(Integer integer);
}
