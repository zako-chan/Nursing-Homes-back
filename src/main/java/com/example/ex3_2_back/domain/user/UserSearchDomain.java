package com.example.ex3_2_back.domain.user;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserSearchDomain {

    @Schema(description = "用户名")
    private String userName;

    @Schema(description = "用户真实姓名")
    private String realName;

    @Schema(description = "性别")
    private String sex;

    @Schema(description = "是否激活")
    private Boolean isActive;
}
