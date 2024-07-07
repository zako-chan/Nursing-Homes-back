package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findByRemoveIsFalse(Pageable pageable);

    Optional<Employee> findById(Integer id);

    Page<Employee> findByUsernameLike(String username,Pageable pageable);

    Optional<Employee> findByIdCard(String idCard);

    Page<Employee> findAll(Specification<Employee> specification, Pageable pageable);

    @Query("SELECT e.birthday FROM Employee e WHERE e.remove = false")
    List<Date> findAllBirthdays();

}
