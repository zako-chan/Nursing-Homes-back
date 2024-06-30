package com.example.ex3_2_back.domain.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeCreateDomain {


    @Schema(description = "工作人员姓名")
    private String username;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "电话")
    private String phone;

    @Schema(description = "身份证号")
    private String idCard;

    @Schema(description = "生日")
    private Date birthday;

    @Schema(description = "入职日期")
    private Date hireDate;

    @Schema(description = "离职日期")
    private Date resignDate;

    @Schema(description = "头像")
    private String profilePhoto;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "是否在职")
    private boolean isActive;
}
