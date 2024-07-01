package com.example.ex3_2_back.entity;

import com.example.ex3_2_back.domain.volunteer.VolunteerCreateDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

/**
 * 义工信息实体类
 */
@Entity
@Table(name = "volunteer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Volunteer {

    /**
     * ID
     * 类型: int
     * 大小: 11
     * 约束: 非空；主键；自增；
     * 备注: 义工id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;

    /**
     * 义工姓名
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String name;

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
     * 访问日期
     * 类型: datetime
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkinDate;

    /**
     * 离开日期
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
     * 描述
     * 类型: varchar
     * 大小: 200
     */
    @Column(length = 200)
    private String description;

    /**
     * 是否有效
     * 类型: boolean
     * 大小: 10
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
    @Column
    private boolean remove;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    public Volunteer(VolunteerCreateDomain volunteerCreateDomain,Integer createBy) {
        this.name = volunteerCreateDomain.getName();
        this.gender = volunteerCreateDomain.getGender();
        this.phone = volunteerCreateDomain.getPhone();
        this.idCard = volunteerCreateDomain.getIdCard();
        this.birthday = volunteerCreateDomain.getBirthday();
        this.checkinDate = volunteerCreateDomain.getCheckinDate();
        this.checkoutDate = volunteerCreateDomain.getCheckoutDate();
        this.profilePhoto = volunteerCreateDomain.getProfilePhoto();
        this.description = volunteerCreateDomain.getDescription();
        this.isActive = volunteerCreateDomain.isActive();
        User user = new User();
        user.setId(createBy);
        this.createBy = user;
        this.updateBy = user;
    }
}
