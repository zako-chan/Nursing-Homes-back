package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Position;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Integer> {

    @Query("SELECT p FROM Position p JOIN FETCH p.wifiInfos")
//    @EntityGraph(attributePaths = "wifiInfos")
    List<Position> findAllWithWifiInfos();
}