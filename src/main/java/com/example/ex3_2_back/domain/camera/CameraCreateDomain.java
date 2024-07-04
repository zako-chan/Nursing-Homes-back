package com.example.ex3_2_back.domain.camera;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CameraCreateDomain {

    /**
     * 摄像头地点
     * 类型: varchar
     * 大小: 50
     */
    @Schema(description = "摄像头地点")
    private String location;

    /**
     * 提供的服务
     */
    @Schema(description = "提供的服务")
    private Integer service;
}
