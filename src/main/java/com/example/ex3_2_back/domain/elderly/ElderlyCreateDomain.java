package com.example.ex3_2_back.domain.elderly;

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
public class ElderlyCreateDomain {

    @Schema(description = "老人姓名")
    private String username;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "电话")
    private String phone;

    @Schema(description = "身份证号")
    private String idCard;

    @Schema(description = "生日")
    private Date birthday;

    @Schema(description = "入住养老院日期")
    private Date checkinDate;

    @Schema(description = "离开养老院日期")
    private Date checkoutDate;

    @Schema(description = "头像")
    private String profilePhoto;

    @Schema(description = "房间号")
    private String roomNumber;

    @Schema(description = "床号")
    private String firstGuardianName;

    @Schema(description = "与第一监护人关系")
    private String firstGuardianRelationship;

    @Schema(description = "第一监护人电话")
    private String firstGuardianPhone;

    @Schema(description = "第一监护人微信")
    private String firstGuardianWechat;

    @Schema(description = "第二监护人姓名")
    private String secondGuardianName;

    @Schema(description = "与第二监护人关系")
    private String secondGuardianRelationship;

    @Schema(description = "第二监护人电话")
    private String secondGuardianPhone;

    @Schema(description = "第二监护人微信")
    private String secondGuardianWechat;

    @Schema(description = "健康状态")
    private String healthState;

    @Schema(description = "老人描述")
    private String description;

    @Schema(description = "是否活跃")
    private boolean isActive;
}