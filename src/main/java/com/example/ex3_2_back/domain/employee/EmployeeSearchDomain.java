package com.example.ex3_2_back.domain.employee;


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
public class EmployeeSearchDomain {


    @Schema(description = "工作人员姓名")
    private String username;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "是否在职")
    private Boolean isActive;
}
