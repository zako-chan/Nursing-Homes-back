package com.example.ex3_2_back.service;


import com.example.ex3_2_back.entity.Elderly;
import com.example.ex3_2_back.exception.ResourceNotExistException;
import com.example.ex3_2_back.repository.ElderlyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ElderlyService {

    ElderlyRepository elderlyRepository;
    @Autowired
    public void setElderlyRepository(ElderlyRepository elderlyRepository) {
        this.elderlyRepository = elderlyRepository;
    }

    /**
     * 查询所有老人信息
     */
    public Page<Elderly> getAllElderly(Pageable pageable) {
        return elderlyRepository.findByRemoveIsFalse(pageable);
    }

    /**
     * 根据老人姓名模糊查询
     */
    public Page<Elderly> getElderlyByUsername(String username, Pageable pageable) {
        return elderlyRepository.findByUsernameLike("%" +username + "%", pageable);
    }

    /**
     * 根据id查询老人信息
     */
    public Optional<Elderly> getElderlyById(Integer id) {
        return elderlyRepository.findById(id);
    }

    /**
     * 添加老人信息,并返回id
     */
    public Integer addElderly(Elderly elderly) {
        Elderly elderly1 = elderlyRepository.save(elderly);
        return elderly1.getId();
    }

    /**
     * 修改老人信息
     */
    public void updateElderly(Elderly elderly) {
        Optional<Elderly> elderlyBefore = elderlyRepository.findById(elderly.getId());
        if (elderlyBefore.isPresent()) {
            elderlyRepository.save(elderly);
        } else {
            throw new ResourceNotExistException("老人不存在");
        }
    }

    /**
     * 删除老人
     */
    public void removeElderly(Integer id) {
        Optional<Elderly> elderly = elderlyRepository.findById(id);
        if (elderly.isPresent()) {
            elderly.get().setRemove(true);
            elderlyRepository.save(elderly.get());
        } else {
            throw new ResourceNotExistException("老人不存在");
        }
    }
}
