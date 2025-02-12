package com.example.ex3_2_back.entity;

import com.example.ex3_2_back.domain.employee.EmployeeCreateDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

/**
 * 工作人员信息实体类
 */
@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
public class Employee {

    /**
     * ID
     * 类型: int
     * 大小: 11
     * 约束: 非空；主键；自增；
     * 备注: 工作人员id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;

    /**
     * 工作人员姓名
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String username;

    /**
     * 性别
     * 类型: char
     * 大小: 5
     */
    @Column(length = 5)
    private String gender;

    /**
     * 电话
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String phone;

    /**
     * 身份证号
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50,unique = true)
    private String idCard;

    /**
     * 出生日期
     * 类型: datetime
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    /**
     * 入职日期
     * 类型: datetime
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;

    /**
     * 离职日期
     * 类型: datetime
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date resignDate;

    /**
     * 图像目录
     * 类型: varchar
     * 大小: 200
     */
    @Column(length = 200)
    private String imgsetDir;

    /**
     * 头像路径
     * 类型: varchar
     * 大小: 200
     */
    @Column(length = 200)
    private String profilePhoto;

    /**
     * 描述
     * 类型: varchar
     * 大小: 200
     */
    @Column(length = 200)
    private String description;

    /**
     * 是否有效
     * 类型: boolean
     */
    private boolean isActive;

    /**
     * 创建时间
     * 类型: datetime
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    /**
     * 创建人
     * 类型: int
     * 大小: 11
     */
    @ManyToOne
    @JoinColumn(name = "createBy", nullable = true)
    private User createBy;

    /**
     * 更新时间
     * 类型: datetime
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    /**
     * 更新人
     * 类型: int
     * 大小: 11
     */
    @ManyToOne
    @JoinColumn(name = "updateBy", nullable = true)
    private User updateBy;

    /**
     * 删除标志
     * 类型: boolean
     */
    @Column(columnDefinition = "boolean default false")
    private boolean remove;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    public Employee(EmployeeCreateDomain employeeCreateDomain,Integer createBy) {
        this.username = employeeCreateDomain.getUsername();
        this.gender = employeeCreateDomain.getGender();
        this.phone = employeeCreateDomain.getPhone();
        this.idCard = employeeCreateDomain.getIdCard();
        this.birthday = employeeCreateDomain.getBirthday();
        this.hireDate = employeeCreateDomain.getHireDate();
        this.resignDate = employeeCreateDomain.getResignDate();
        this.profilePhoto = employeeCreateDomain.getProfilePhoto();
        this.description = employeeCreateDomain.getDescription();
        this.isActive = employeeCreateDomain.isActive();
        this.remove = false;
        User user = new User();
        user.setId(createBy);
        this.createBy = user;
        this.updateBy = user;
    }
}
