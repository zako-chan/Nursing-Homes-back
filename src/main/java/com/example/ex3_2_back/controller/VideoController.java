package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.log.AutoTakeCount;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
@Slf4j
@AutoTakeCount
@Tag(name = "视频管理", description = "查看视频信息")
public class VideoController {

    @GetMapping
    public TResult getVideo() {

        return null;
    }

}
