package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
