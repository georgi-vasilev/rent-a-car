package com.group.carrentalserver.repository;

import com.group.carrentalserver.domain.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {

    Optional<Location> findById(Integer integer);
}
