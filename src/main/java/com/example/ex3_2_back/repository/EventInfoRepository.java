package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.EventInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventInfoRepository extends JpaRepository<EventInfo,Integer> {
    Page<EventInfo> findAllByOrderByEventDateDesc(Pageable pageable);

    Page<EventInfo> findAll(Specification<EventInfo> specification, Pageable pageable);
}
