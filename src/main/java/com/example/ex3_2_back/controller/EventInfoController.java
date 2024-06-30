package com.example.ex3_2_back.controller;


import com.example.ex3_2_back.domain.TResult;
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
                                               @Schema(defaultValue = "10") @RequestParam int pageSize,) {

        Page<EventInfo> eventInfos = eventInfoService.getAllEvent(PageRequest.of(page,pageSize));
        return TResult.success(eventInfos);
    }
}
