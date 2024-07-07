package com.example.ex3_2_back.controller;


import com.example.ex3_2_back.annotations.CurrentUserId;
import com.example.ex3_2_back.domain.count.AgeGroupCountDTO;
import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.domain.count.EventCountDTO;
import com.example.ex3_2_back.domain.elderly.ElderlyCreateDomain;
import com.example.ex3_2_back.domain.elderly.ElderlySearchDomain;
import com.example.ex3_2_back.entity.Elderly;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.log.AutoTakeCount;
import com.example.ex3_2_back.service.ElderlyService;
import com.example.ex3_2_back.service.EventInfoService;
import com.example.ex3_2_back.service.VisionService;
import com.example.ex3_2_back.utils.IdentityConstant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elderly")
@Slf4j
@AutoTakeCount
@Tag(name = "老人管理",description = "管理老人信息")
public class ElderlyController {

    ElderlyService elderlyService;
    @Autowired
    public void setElderlyService(ElderlyService elderlyService) {
        this.elderlyService = elderlyService;
    }

    VisionService visionService;
    @Autowired
    public void setVisionService(VisionService visionService) {
        this.visionService = visionService;
    }

    EventInfoService eventInfoService;
    @Autowired
    public void setEventInfoService(EventInfoService eventInfoService) {
        this.eventInfoService = eventInfoService;
    }
    @GetMapping
    @Operation(summary = "查询所有老人", description = "查询所有老人")
    public TResult<Page<Elderly>> allElderly(@Schema(defaultValue = "0") @RequestParam int page,
                                             @Schema(defaultValue = "10") @RequestParam int pageSize,
                                             @RequestParam(required = false) String username) {
        if(username != null) {
            Page<Elderly> elderlies = elderlyService.getElderlyByUsername(username, PageRequest.of(page,pageSize));
            return TResult.success(elderlies);
        }
        Page<Elderly> elderlies = elderlyService.getAllElderly(PageRequest.of(page,pageSize));
        return TResult.success(elderlies);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据id查询老人", description = "根据id查询老人")
    public TResult<Elderly> getElderlyById(@Schema(description = "老人id") @PathVariable Integer id) {
        Elderly elderly = elderlyService.getElderlyById(id).orElse(null);
        return TResult.success(elderly);
    }

    @PostMapping
    @Operation(summary = "添加老人", description = "添加老人")
    public TResult<Integer> addElderly(@Schema(hidden = true) @CurrentUserId Integer userId,
                                       @RequestBody ElderlyCreateDomain elderlyCreateDomain) {

        Elderly elderly = new Elderly(elderlyCreateDomain, userId);
        Integer id = elderlyService.addElderly(elderly);
        return TResult.success(id);
    }

    @PutMapping
    @Operation(summary = "修改老人信息", description = "修改老人信息")
    public TResult<Void> updateElderly(@Schema(hidden = true) @CurrentUserId Integer userId,
                                       @RequestBody Elderly elderly) {
        User user = new User();
        user.setId(userId);
        elderly.setUpdateBy(user);
        elderlyService.updateElderly(elderly);
        return TResult.success();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除老人", description = "删除老人")
    public TResult<Void> deleteElderly(@Schema(description = "老人id") @PathVariable Integer id) {
        Elderly elderly = elderlyService.getElderlyById(id).orElseThrow(() -> new RuntimeException("老人不存在"));
        visionService.removeUrl(id, IdentityConstant.ELDERLY, elderly.getUsername());
        elderlyService.removeElderly(id);
        return TResult.success();
    }

    @PostMapping("/search")
    @Operation(summary = "查找老人", description = "动态查找老人")
    public TResult<Page<Elderly>> searchElderly(@RequestBody ElderlySearchDomain elderlySearchDomain,
                                                @RequestParam int page,
                                                @RequestParam int pageSize) {
        return TResult.success(elderlyService.searchElderlyDynamic(elderlySearchDomain,PageRequest.of(page,pageSize)));
    }

    //TODO
    @GetMapping("/faceCollection")
    @Operation(summary = "人脸采集", description = "人脸采集")
    public TResult faceCollection(@RequestParam Integer userId,
                                  @RequestParam String userName) {
        visionService.faceCollection(userId, IdentityConstant.ELDERLY, userName);
        return TResult.success();
    }

    @GetMapping("/ageGroups")
    @Operation(summary = "数据统计", description = "老年人年龄数据统计")
    public TResult<List<AgeGroupCountDTO>> getAgeGroupCounts() {
        return TResult.success(elderlyService.getAgeGroupCounts());
    }

}
