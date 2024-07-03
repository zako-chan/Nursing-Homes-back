package com.example.ex3_2_back.service;


import com.example.ex3_2_back.domain.employee.EmployeeSearchDomain;
import com.example.ex3_2_back.domain.employee.EmployeeSearchDomain;
import com.example.ex3_2_back.entity.Employee;
import com.example.ex3_2_back.entity.Employee;
import com.example.ex3_2_back.exception.ResourceNotExistException;
import com.example.ex3_2_back.repository.EmployeeRepository;
import com.example.ex3_2_back.utils.UpdateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.Rfc3492Idn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;
    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * 查询所有员工信息
     */
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.findByRemoveIsFalse(pageable);
    }

    /**
     * 根据员工姓名模糊查询
     */
    public Page<Employee> getEmployeeByUsername(String username, Pageable pageable) {
        return employeeRepository.findByUsernameLike("%" +username + "%", pageable);
    }

    /**
     * 根据id查询员工信息
     */
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    /**
     * 添加员工信息,并返回id
     */
    public Integer addEmployee(Employee employee) {
        Optional<Employee> employeeByIdCard = employeeRepository.findByIdCard(employee.getIdCard());
        if (employeeByIdCard.isPresent()) {
            throw new ResourceNotExistException("身份证号已存在");
        }
        Employee employee1 = employeeRepository.save(employee);
        return employee1.getId();
    }

    /**
     * 修改员工信息
     */
    public void updateEmployee(Employee employee) {
        Optional<Employee> employeeBefore = employeeRepository.findById(employee.getId());
        if (employeeBefore.isPresent()) {
            Employee employee1 = employeeBefore.get();
            UpdateUtil.copyNotNullProperties(employee, employee1);
            employeeRepository.save(employee1);
        } else {
            throw new ResourceNotExistException("员工不存在");
        }
    }

    /**
     * 删除员工信息
     */
    public void removeEmployee(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employee.get().setRemove(true);
            employeeRepository.save(employee.get());
        } else {
            throw new ResourceNotExistException("员工不存在");
        }
    }
    
    /**
     * 根据条件动态查询员工信息
     */
    public Page<Employee> searchEmployeeDynamic(EmployeeSearchDomain employeeSearchDomain, Pageable pageable) {
        Specification<Employee> queryCondition = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (employeeSearchDomain.getUsername() != null && !employeeSearchDomain.getUsername().isEmpty()) {
                    predicateList.add(criteriaBuilder.like(root.get("username"), "%" + employeeSearchDomain.getUsername() + "%"));
                }
                if (employeeSearchDomain.getGender() != null && !employeeSearchDomain.getGender().isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("gender"), employeeSearchDomain.getGender()));
                }
                if(employeeSearchDomain.getIsActive() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("isActive"), employeeSearchDomain.getIsActive()));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };

        return employeeRepository.findAll(queryCondition, pageable);
    }
}
