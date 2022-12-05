package com.group.carrentalserver.repository;

import com.group.carrentalserver.domain.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment,Integer> {

    Optional<Equipment> findById(Integer integer);
}
