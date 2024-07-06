package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
