package com.example.ex3_2_back.controller;


import com.example.ex3_2_back.annotations.CurrentUserId;
import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.domain.elderly.ElderlyCreateDomain;
import com.example.ex3_2_back.entity.Elderly;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.log.AutoTakeCount;
import com.example.ex3_2_back.service.ElderlyService;
import com.example.ex3_2_back.utils.CurrentUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    @Operation(summary = "查询所有老人", description = "查询所有老人")
    public TResult<Page<Elderly>> allElderly(@Schema(defaultValue = "0") @RequestParam int page,
                                             @Schema(defaultValue = "10") @RequestParam int pageSize,
                                             @Schema(required = false) @RequestParam String username) {
        if(username != null) {
            Page<Elderly> elderlies = elderlyService.getElderlyByUsername(username, PageRequest.of(page,pageSize));
            return TResult.success(elderlies);
        }
        Page<Elderly> elderlies = elderlyService.getAllElderly(PageRequest.of(page,pageSize));
        return TResult.success(elderlies);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据id查询老人", description = "根据id查询老人")
    public TResult<Elderly> getElderlyById(@Schema(description = "老人id") @RequestParam Integer id) {
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
        elderly.setUpdateBy(userId);
        elderlyService.updateElderly(elderly);
        return TResult.success();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除老人", description = "删除老人")
    public TResult<Void> deleteElderly(@Schema(description = "老人id") @RequestParam Integer id) {
        elderlyService.removeElderly(id);
        return TResult.success();
    }

}
