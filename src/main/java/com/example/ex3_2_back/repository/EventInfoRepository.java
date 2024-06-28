package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.EventInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventInfoRepository extends JpaRepository<EventInfo,Integer> {
}
