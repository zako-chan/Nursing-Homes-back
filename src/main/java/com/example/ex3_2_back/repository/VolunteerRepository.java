package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Volunteer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VolunteerRepository extends JpaRepository<Volunteer,Integer> {
    Page<Volunteer> findByRemoveIsFalse(org.springframework.data.domain.Pageable pageable);

    Optional<Volunteer> findById(Integer id);

    Page<Volunteer> findByNameLike(String name,org.springframework.data.domain.Pageable pageable);
}
