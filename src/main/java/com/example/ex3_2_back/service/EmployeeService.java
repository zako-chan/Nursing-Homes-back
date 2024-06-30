package com.example.ex3_2_back.service;


import com.example.ex3_2_back.entity.Employee;
import com.example.ex3_2_back.exception.ResourceNotExistException;
import com.example.ex3_2_back.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.Rfc3492Idn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        Employee employee1 = employeeRepository.save(employee);
        return employee1.getId();
    }

    /**
     * 修改员工信息
     */
    public void updateEmployee(Employee employee) {
        Optional<Employee> employeeBefore = employeeRepository.findById(employee.getId());
        if (employeeBefore.isPresent()) {
            employeeRepository.save(employee);
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
}
