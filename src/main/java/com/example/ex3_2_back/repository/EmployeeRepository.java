package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findByRemoveIsFalse(Pageable pageable);

    Optional<Employee> findById(Integer id);

    Page<Employee> findByUsernameLike(String username,Pageable pageable);

    Optional<Employee> findByIdCard(String idCard);
}
