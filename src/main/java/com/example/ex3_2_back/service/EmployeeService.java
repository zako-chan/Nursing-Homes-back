package com.example.ex3_2_back.service;


import com.example.ex3_2_back.domain.count.AgeGroupCountDTO;
import com.example.ex3_2_back.domain.employee.EmployeeSearchDomain;
import com.example.ex3_2_back.entity.Employee;
import com.example.ex3_2_back.exception.ResourceNotExistException;
import com.example.ex3_2_back.repository.EmployeeRepository;
import com.example.ex3_2_back.utils.UpdateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<AgeGroupCountDTO> getAgeGroupCounts() {
        List<Date> birthdays = employeeRepository.findAllBirthdays();
        Map<String, Integer> ageGroupCounts = initializeAgeGroups();

        for (Date birthday : birthdays) {
            int age = calculateAge(birthday);
            String ageGroup = determineAgeGroup(age);
            ageGroupCounts.put(ageGroup, ageGroupCounts.getOrDefault(ageGroup, 0) + 1);
        }

        return ageGroupCounts.entrySet().stream()
                .map(entry -> new AgeGroupCountDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    private Map<String, Integer> initializeAgeGroups() {
        Map<String, Integer> ageGroupCounts = new LinkedHashMap<>();
        ageGroupCounts.put("25-30", 0);
        ageGroupCounts.put("31-35", 0);
        ageGroupCounts.put("36-40", 0);
        ageGroupCounts.put("41-45", 0);
        ageGroupCounts.put("46-50", 0);
        ageGroupCounts.put("51-55", 0);
        ageGroupCounts.put("56-60", 0);
        ageGroupCounts.put("61-65", 0);
        ageGroupCounts.put("66-70", 0);
        ageGroupCounts.put("71-75", 0);
        ageGroupCounts.put("76-80", 0);
        ageGroupCounts.put("80+", 0);
        return ageGroupCounts;
    }

    private int calculateAge(Date birthday) {
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthday);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    private String determineAgeGroup(int age) {
        if (age >= 80) return "80+";
        if (age >= 76) return "76-80";
        if (age >= 71) return "71-75";
        if (age >= 66) return "66-70";
        if (age >= 61) return "61-65";
        if (age >= 56) return "56-60";
        if (age >= 51) return "51-55";
        if (age >= 46) return "46-50";
        if (age >= 41) return "41-45";
        if (age >= 36) return "36-40";
        if (age >= 31) return "31-35";
        if (age >= 25) return "25-30";
        return "Under 25";  // 这里可以根据你的需求添加更多年龄段
    }
}
