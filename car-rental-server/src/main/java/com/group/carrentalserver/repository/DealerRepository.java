package com.group.carrentalserver.repository;

import com.group.carrentalserver.domain.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Integer> {

    Optional<Dealer> findById(Integer integer);
}
