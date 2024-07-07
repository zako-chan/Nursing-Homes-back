package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Volunteer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VolunteerRepository extends JpaRepository<Volunteer,Integer> {
    Page<Volunteer> findByRemoveIsFalse(org.springframework.data.domain.Pageable pageable);

    Optional<Volunteer> findById(Integer id);

    Page<Volunteer> findByNameLike(String name,org.springframework.data.domain.Pageable pageable);

    Optional<Volunteer> findByIdCard(String idCard);

    Page<Volunteer> findAll(Specification<Volunteer> specification, org.springframework.data.domain.Pageable pageable);

    @Query("SELECT v.birthday FROM Volunteer v WHERE v.remove = false")
    List<Date> findAllBirthdays();
}
