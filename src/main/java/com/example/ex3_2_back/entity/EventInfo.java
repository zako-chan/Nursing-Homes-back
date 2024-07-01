package com.example.ex3_2_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

/**
 * 事件信息实体类
 */
@Entity
@Table(name = "event")
@Data
@AllArgsConstructor
@Builder
public class EventInfo {

    /**
     * ID
     * 类型: int
     * 大小: 11
     * 约束: 非空；主键；自增；
     * 备注: 事件id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;

    /**
     * 事件类型
     * 类型: int
     * 大小: 11
     * 备注: 0代表情感检测，1代表义工交互检测，2代表陌生人检测，3代表摔倒检测，4代表禁止区域入侵检测
     */
    @Column
    private int eventType;

    /**
     * 事件发生的时间
     * 类型: datetime
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;

    /**
     * 事件发生的地点
     * 类型: varchar
     * 大小: 200
     */
    @Column(length = 200)
    private String eventLocation;

    /**
     * 事件描述
     * 类型: varchar
     * 大小: 200
     */
    @Column(length = 200)
    private String eventDesc;

    /**
     * 事件截图url
     */
    @Column(length = 200)
    private String eventImgUrl;

    /**
     * 老人id
     * 类型: int
     * 大小: 11
     * 备注: 和老人信息表的id关联
     */
//    @Column
//    private int oldpersonId;

    /**
     * 老人id
     * 类型: int
     * 大小: 11
     * 备注: 和老人信息表的id关联
     */
    @ManyToOne
    @JoinColumn(name = "elderly_id", nullable = true)
    private Elderly elderly;

    @PrePersist
    protected void onCreate() {
        eventDate = new Date();
    }


    public EventInfo(int eventType, Date eventDate, String eventLocation, String eventDesc, Elderly elderly) {
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventDesc = eventDesc;
        this.elderly = elderly;
    }

    public EventInfo(){}
}
