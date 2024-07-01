package com.example.ex3_2_back.service;

import com.example.ex3_2_back.entity.Volunteer;
import com.example.ex3_2_back.exception.ResourceNotExistException;
import com.example.ex3_2_back.repository.VolunteerRepository;
import com.example.ex3_2_back.utils.UpdateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class VolunteerService {

    VolunteerRepository volunteerRepository;
    @Autowired
    public void setVolunteerRepository(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    /**
     * 查询所有志愿者信息
     */
    public Page<Volunteer> getAllVolunteer(Pageable pageable) {
        return volunteerRepository.findByRemoveIsFalse(pageable);
    }

    /**
     * 根据志愿者姓名模糊查询
     */
    public Page<Volunteer> getVolunteerByName(String name, Pageable pageable) {
        return volunteerRepository.findByNameLike("%" +name + "%", pageable);
    }

    /**
     * 根据id查询老人信息
     */
    public Optional<Volunteer> getVolunteerById(Integer id) {
        return volunteerRepository.findById(id);
    }

    /**
     * 添加志愿者信息,并返回id
     */
    public Integer addVolunteer(Volunteer volunteer) {
        Optional<Volunteer> volunteerByIdCard = volunteerRepository.findByIdCard(volunteer.getIdCard());
        if (volunteerByIdCard.isPresent()) {
            throw new ResourceNotExistException("身份证号已存在");
        }
        Volunteer volunteer1 = volunteerRepository.save(volunteer);
        return volunteer1.getId();
    }

    /**
     * 修改志愿者信息
     */
    public void updateVolunteer(Volunteer volunteer) {
        Optional<Volunteer> volunteerBefore = volunteerRepository.findById(volunteer.getId());
        if (volunteerBefore.isPresent()) {
            Volunteer volunteer1 = volunteerBefore.get();
            UpdateUtil.copyNotNullProperties(volunteer, volunteer1);
            volunteerRepository.save(volunteer1);
        }else {
            throw new ResourceNotExistException("志愿者不存在");
        }
    }

    /**
     * 删除志愿者信息
     */
    public void deleteVolunteer(Integer id) {
        Optional<Volunteer> volunteerBefore = volunteerRepository.findById(id);
        if (volunteerBefore.isPresent()) {
            Volunteer volunteer = volunteerBefore.get();
            volunteer.setRemove(true);
            volunteerRepository.save(volunteer);
        } else {
            throw new ResourceNotExistException("志愿者不存在");
        }
    }
}
