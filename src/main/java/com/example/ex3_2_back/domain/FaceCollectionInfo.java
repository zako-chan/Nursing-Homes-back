package com.example.ex3_2_back.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FaceCollectionInfo {
    @Schema(description = "视频推流地址")
    String rtcUrl;
    @Schema(description = "用户id")
    Integer userId;
    @Schema(description = "用户身份")
    String identity;
    @Schema(description = "用户姓名")
    String userName;
}
