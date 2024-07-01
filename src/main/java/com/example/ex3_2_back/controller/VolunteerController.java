package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.annotations.CurrentUserId;
import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.domain.volunteer.VolunteerCreateDomain;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.entity.Volunteer;
import com.example.ex3_2_back.log.AutoTakeCount;
import com.example.ex3_2_back.service.VolunteerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteer")
@AutoTakeCount
@Tag(name = "义工管理", description = "管理义工信息")
public class VolunteerController {

    VolunteerService volunteerService;

    @Autowired
    public void setVolunteerService(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @GetMapping
    @Operation(summary = "查询所有义工", description = "查询所有义工")
    public TResult<Page<Volunteer>> allVolunteers(@Schema(defaultValue = "0") @RequestParam int page,
                                                  @Schema(defaultValue = "10") @RequestParam int pageSize,
                                                  @RequestParam(required = false) String username){
        if (username != null) {
            Page<Volunteer> volunteers = volunteerService.getVolunteerByName(username, PageRequest.of(page, pageSize));
            return TResult.success(volunteers);
        }else {
            Page<Volunteer> volunteers = volunteerService.getAllVolunteer(PageRequest.of(page, pageSize));
            return TResult.success(volunteers);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据id查询义工", description = "根据id查询义工")
    public TResult<Volunteer> getVolunteerById(@Schema(description = "义工id") @PathVariable Integer id) {
        Volunteer volunteer = volunteerService.getVolunteerById(id).orElse(null);
        return TResult.success(volunteer);

    }

    @PostMapping
    @Operation(summary = "添加义工", description = "添加义工")
    public TResult<Integer> addVolunteer(@Schema(hidden = true) @CurrentUserId Integer userId,
                                        @RequestBody VolunteerCreateDomain volunteerCreateDomain) {
        Volunteer volunteer = new Volunteer(volunteerCreateDomain,userId);
        Integer id = volunteerService.addVolunteer(volunteer);
        return TResult.success(id);
    }

    @PutMapping
    @Operation(summary = "修改义工信息", description = "修改义工信息")
    public TResult updateVolunteer(@Schema(hidden = true) @CurrentUserId Integer userId,
                                  @RequestBody Volunteer volunteer) {
        User user = new User();
        user.setId(userId);
        volunteer.setUpdateBy(user);
        volunteerService.updateVolunteer(volunteer);
        return TResult.success();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除义工", description = "删除义工")
    public TResult deleteVolunteer(@Schema(description = "义工id") @PathVariable Integer id) {
        volunteerService.deleteVolunteer(id);
        return TResult.success();
    }
}