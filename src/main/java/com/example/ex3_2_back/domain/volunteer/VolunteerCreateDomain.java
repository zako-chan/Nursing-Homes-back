package com.example.ex3_2_back.domain.volunteer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class VolunteerCreateDomain {

    @Schema(description = "志愿者姓名")
    private String name;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "电话")
    private String phone;

    @Schema(description = "身份证号")
    private String idCard;

    @Schema(description = "生日")
    private Date birthday;

    @Schema(description = "访问日期")
    private Date checkinDate;

    @Schema(description = "离开日期")
    private Date checkoutDate;

    @Schema(description = "头像")
    private String profilePhoto;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "是否在职")
    private boolean isActive;
}
