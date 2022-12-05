package com.group.carrentalserver.repository;

import com.group.carrentalserver.domain.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {

    Optional<Insurance> findById(Integer integer);
}
