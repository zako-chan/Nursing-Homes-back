package com.example.ex3_2_back.entity;

import com.example.ex3_2_back.domain.auth.RegisterDomain;
import com.example.ex3_2_back.domain.user.UserCreateDomain;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.Date;

/**
 * 系统管理员信息实体类
 */
@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    /**
     * ID
     * 类型: int
     * 大小: 11
     * 约束: 非空；主键；自增；
     * 备注: 系统管理员id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;

    /**
     * 用户名
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String userName;

    /**
     * 密码
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String password;

    /**
     * 用户真实姓名
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String realName;

    /**
     * 性别
     * 类型: varchar
     * 大小: 20
     */
    @Column(length = 20)
    private String sex;

    /**
     * 邮箱
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String email;

    /**
     * 电话
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String phone;

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
    @Column(columnDefinition = "boolean default true")
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
//    @Column
//    private int createBy;

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
    @Column
    private int updateBy;

    /**
     * 删除标志
     * 类型: boolean
     */
    @Column
    private boolean remove;

    public User(UserCreateDomain userCreateDomain) {
        this.userName = userCreateDomain.getUserName();
        this.password = userCreateDomain.getPassword();
        this.realName = userCreateDomain.getRealName();
        this.sex = userCreateDomain.getSex();
        this.phone = userCreateDomain.getPhone();
        this.email = userCreateDomain.getEmail();
        this.description = userCreateDomain.getDescription();
        this.isActive = userCreateDomain.isActive();
        this.remove = false;
    }

    public User(RegisterDomain registerDomain) {
        this.userName = registerDomain.getUserName();
        this.password = registerDomain.getPassword();
        this.realName = registerDomain.getRealName();
        this.email = registerDomain.getEmail();
        this.phone = registerDomain.getPhone();
        this.remove = false;
    }
}
