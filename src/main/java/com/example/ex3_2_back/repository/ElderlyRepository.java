package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Elderly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ElderlyRepository extends JpaRepository<Elderly,Integer> {

    Page<Elderly> findByRemoveIsFalse(Pageable pageable);

    Optional<Elderly> findById(Integer id);

    Page<Elderly> findByUsernameLike(String username,Pageable pageable);

    Optional<Elderly> findByIdCard(String idCard);

    Page<Elderly> findAll(Specification<Elderly> specification, Pageable pageable);

    @Query("SELECT e.birthday FROM Elderly e WHERE e.remove = false")
    List<Date> findAllBirthdays();
}
