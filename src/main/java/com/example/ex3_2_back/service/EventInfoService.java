package com.example.ex3_2_back.service;

import com.example.ex3_2_back.domain.count.Interaction;
import com.example.ex3_2_back.entity.EventInfo;
import com.example.ex3_2_back.repository.EventInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 查询义工交互前5
     */
    public List<Interaction> getTopVolunteersByEventType(int eventType, int y) {
        return eventInfoRepository.findTopVolunteersByEventType(eventType, PageRequest.of(0, y));
    }

    /**
     * 查询老人心情
     */
    public Map<String, Long> getEventDescCounts(int elderlyId) {
        List<Object[]> results = eventInfoRepository.countEventDescByEventTypeAndElderlyId(elderlyId);
        Map<String, Long> eventDescCounts = new HashMap<>();
        for (Object[] result : results) {
            String eventDesc = (String) result[0];
            Long count = (Long) result[1];
            eventDescCounts.put(eventDesc, count);
        }
        return eventDescCounts;
    }
}

