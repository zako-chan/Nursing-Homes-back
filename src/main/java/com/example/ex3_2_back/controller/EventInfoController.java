package com.example.ex3_2_back.controller;


import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.domain.count.EmotionCount;
import com.example.ex3_2_back.domain.count.EventCountDTO;
import com.example.ex3_2_back.domain.count.Interaction;
import com.example.ex3_2_back.entity.EventInfo;
import com.example.ex3_2_back.log.AutoTakeCount;
import com.example.ex3_2_back.service.EventInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eventinfo")
@AutoTakeCount
@Tag(name = "事件管理", description = "管理事件信息")
public class EventInfoController {
    EventInfoService eventInfoService;
    @Autowired
    public void setEventInfoService(EventInfoService eventInfoService) {
        this.eventInfoService = eventInfoService;
    }

    @GetMapping
    @Operation(summary = "查询所有事件", description = "查询所有事件")
    public TResult<Page<EventInfo>> allElderly(@Schema(defaultValue = "0") @RequestParam int page,
                                               @Schema(defaultValue = "10") @RequestParam int pageSize) {

        Page<EventInfo> eventInfos = eventInfoService.getAllEvent(PageRequest.of(page,pageSize));
        return TResult.success(eventInfos);
    }

    @GetMapping("/elderly")
    @Operation(summary = "心情统计", description = "老年人心情事件统计")
    public TResult<Map<String,Long>> getEventCounts(@RequestParam int elderlyId) {
        return TResult.success(eventInfoService.getEventDescCounts(elderlyId));
    }

    @GetMapping("/volunteer")
    @Operation(summary = "事件统计", description = "义工事件统计，查找义工交互次数前5")
    public TResult<List<Interaction>> getTopInteractionCounts() {
        return TResult.success(eventInfoService.getTopVolunteersByEventType(1,5));
    }
}
