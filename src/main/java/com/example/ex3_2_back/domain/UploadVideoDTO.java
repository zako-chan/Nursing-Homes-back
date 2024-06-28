package com.example.ex3_2_back.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UploadVideoDTO {

    @NotBlank
    @Schema(description = "视频地址")
    private String videoUrl;

    @NotBlank
    @Schema(description = "视频封面地址")
    private String imgUrl;

    @NotBlank
    @Schema(description = "视频标题")
    private String title;

    @NotNull
    @Schema(description = "是否私有")
    private Boolean isPrivate;

    @Schema(description = "视频描述")
    private String description;
}
