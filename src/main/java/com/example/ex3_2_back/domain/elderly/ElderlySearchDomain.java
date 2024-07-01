package com.example.ex3_2_back.domain.elderly;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ElderlySearchDomain {
    @Schema(description = "老人姓名")
    private String username;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "房间号")
    private String roomNumber;

    @Schema(description = "健康状态")
    private String healthState;

    @Schema(description = "是否活跃")
    private Boolean isActive;
}
