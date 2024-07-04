package com.example.ex3_2_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 摄像头类
 */
@Entity
@Table(name = "camera")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
public class Camera {
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
     * 摄像头名地点
     * 类型: varchar
     * 大小: 50
     */
    @Column(length = 50)
    private String location;


    /**
     * 删除标志
     * 类型: boolean
     */
    @Column(columnDefinition = "boolean default false")
    private boolean remove;

    /**
     * 推流地址
     */
    @Column
    private String rtmpUrl;

    /**
     * 原始视频地址
     */
    @Column
    private String originalUrl;

    /**
     * 服务处理后的地址
     */
    @Column
    private String processUrl;

    /**
     * 提供的服务
     */
    @Column
    private Integer service;


    /**
     * 是否开启
     * 类型: boolean
     */
    @Column(columnDefinition = "boolean default false")
    private boolean isActive;
}
