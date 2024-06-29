package com.example.ex3_2_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

/**
 * 老人信息实体类
 */
@Entity
@Table(name = "elderly")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Elderly {

    /**
     * ID
     * 类型: int
     * 大小: 11
     * 约束: 非空；主键；自增；
     * 备注: 老人id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;

    /**
     * 老人姓名
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
    @Column(length = 50)
    private String idCard;

    /**
     * 出生日期
     * 类型: datetime
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    /**
     * 入养老院日期
     * 类型: datetime
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkinDate;

    /**
     * 离开养老院日期
     * 类型: datetime
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkoutDate;

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
     * 房间号
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String roomNumber;

    /**
     * 第一监护人姓名
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String firstGuardianName;

    /**
     * 与第一监护人关系
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String firstGuardianRelationship;

    /**
     * 第一监护人电话
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String firstGuardianPhone;

    /**
     * 第一监护人微信
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String firstGuardianWechat;

    /**
     * 第二监护人姓名
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String secondGuardianName;

    /**
     * 与第二监护人关系
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String secondGuardianRelationship;

    /**
     * 第二监护人电话
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String secondGuardianPhone;

    /**
     * 第二监护人微信
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String secondGuardianWechat;

    /**
     * 健康状况
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String healthState;

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
    @Column
    private int createBy;

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
}
