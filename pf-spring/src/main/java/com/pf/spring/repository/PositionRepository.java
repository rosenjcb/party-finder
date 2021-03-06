package com.pf.spring.repository;

import com.pf.spring.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PositionRepository extends JpaRepository<Position, UUID> {

    Optional<Position> findPositionById(UUID id);
}
