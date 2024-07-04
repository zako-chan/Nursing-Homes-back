package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.annotations.CurrentUserId;
import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.domain.elderly.ElderlySearchDomain;
import com.example.ex3_2_back.domain.employee.EmployeeSearchDomain;
import com.example.ex3_2_back.entity.Elderly;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.log.AutoTakeCount;
import com.example.ex3_2_back.service.EmployeeService;
import com.example.ex3_2_back.domain.employee.EmployeeCreateDomain;
import com.example.ex3_2_back.entity.Employee;
import com.example.ex3_2_back.service.VisionService;
import com.example.ex3_2_back.utils.IdentityConstant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@AutoTakeCount
@Tag(name = "员工管理", description = "管理员工信息")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    VisionService visionService;
    @Autowired
    public void setVisionService(VisionService visionService) {
        this.visionService = visionService;
    }

    @GetMapping
    @Operation(summary = "查询所有员工", description = "查询所有员工")
    public TResult<Page<Employee>> allEmployees(@Schema(defaultValue = "0") @RequestParam int page,
                                       @Schema(defaultValue = "10") @RequestParam int pageSize,
                                       @RequestParam(required = false) String username){
        if (username != null) {
            Page<Employee> employees = employeeService.getEmployeeByUsername(username, PageRequest.of(page, pageSize));
            return TResult.success(employees);
        }else {
            Page<Employee> employees = employeeService.getAllEmployee(PageRequest.of(page, pageSize));
            return TResult.success(employees);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据id查询员工", description = "根据id查询员工")
    public TResult<Employee> getEmployeeById(@Schema(description = "员工id") @PathVariable Integer id) {
        Employee employee = employeeService.getEmployeeById(id).orElse(null);
        return TResult.success(employee);

    }

    @PostMapping
    @Operation(summary = "添加员工", description = "添加员工")
    public TResult<Integer> addEmployee(@Schema(hidden = true) @CurrentUserId Integer userId,
                                        @RequestBody EmployeeCreateDomain employeeCreateDomain) {
        Employee employee = new Employee(employeeCreateDomain,userId);
        Integer id = employeeService.addEmployee(employee);
        return TResult.success(id);
    }

    @PutMapping
    @Operation(summary = "修改员工信息", description = "修改员工信息")
    public TResult updateEmployee(@Schema(hidden = true) @CurrentUserId Integer userId,
                               @RequestBody Employee employee) {
        User user = new User();
        user.setId(userId);
        employee.setUpdateBy(user);
        employeeService.updateEmployee(employee);
        return TResult.success();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除员工", description = "删除员工")
    public TResult deleteEmployee(@Schema(description = "员工id") @PathVariable Integer id) {
        Employee employee = employeeService.getEmployeeById(id).orElseThrow(() -> new RuntimeException("员工不存在"));
        visionService.removeUrl(id, IdentityConstant.EMPLOYEE, employee.getUsername());
        employeeService.removeEmployee(id);
        return TResult.success();
    }

    @PostMapping("/search")
    @Operation(summary = "查找员工", description = "动态查找员工")
    public TResult<Page<Employee>> searchElderly(@RequestBody EmployeeSearchDomain employeeSearchDomain,
                                                @RequestParam int page,
                                                @RequestParam int pageSize) {
        return TResult.success(employeeService.searchEmployeeDynamic(employeeSearchDomain,PageRequest.of(page,pageSize)));
    }
}