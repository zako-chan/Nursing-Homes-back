package com.example.ex3_2_back.service;

import com.example.ex3_2_back.entity.EventInfo;
import com.example.ex3_2_back.repository.EventInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventInfoService {
    EventInfoRepository eventInfoRepository;
    @Autowired
    public void setEventInfoRepository(EventInfoRepository eventInfoRepository) {
        this.eventInfoRepository = eventInfoRepository;
    }

    /**
     * 查询所有事件
     */
    public Page<EventInfo> getAllEvent(Pageable pageable) {
        return eventInfoRepository.findAllByOrderByEventDateDesc(pageable);
    }
}
