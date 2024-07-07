package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.domain.count.Interaction;
import com.example.ex3_2_back.entity.EventInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventInfoRepository extends JpaRepository<EventInfo,Integer> {
    Page<EventInfo> findAllByOrderByEventDateDesc(Pageable pageable);

    Page<EventInfo> findAll(Specification<EventInfo> specification, Pageable pageable);

    @Query("SELECT new com.example.ex3_2_back.domain.count.Interaction(e.volunteer, COUNT(e)) " +
            "FROM EventInfo e " +
            "WHERE e.eventType = :eventType " +
            "GROUP BY e.volunteer " +
            "ORDER BY COUNT(e) DESC")
    List<Interaction> findTopVolunteersByEventType(@Param("eventType") int eventType, Pageable pageable);

    @Query("SELECT e.eventDesc, COUNT(e) " +
            "FROM EventInfo e " +
            "WHERE e.eventType = 0 AND e.elderly.id = :elderlyId " +
            "GROUP BY e.eventDesc")
    List<Object[]> countEventDescByEventTypeAndElderlyId(@Param("elderlyId") int elderlyId);

}
