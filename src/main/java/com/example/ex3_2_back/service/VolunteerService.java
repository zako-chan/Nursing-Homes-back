package com.example.ex3_2_back.service;

import com.example.ex3_2_back.domain.count.AgeGroupCountDTO;
import com.example.ex3_2_back.domain.volunteer.VolunteerSearchDomain;
import com.example.ex3_2_back.entity.Volunteer;
import com.example.ex3_2_back.exception.ResourceNotExistException;
import com.example.ex3_2_back.repository.VolunteerRepository;
import com.example.ex3_2_back.utils.UpdateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * 根据条件动态查询义工信息
     */
    public Page<Volunteer> searchVolunteerDynamic(VolunteerSearchDomain volunteerSearchDomain, Pageable pageable) {
        Specification<Volunteer> queryCondition = new Specification<Volunteer>() {
            @Override
            public Predicate toPredicate(Root<Volunteer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (volunteerSearchDomain.getName() != null && !volunteerSearchDomain.getName().isEmpty()) {
                    predicateList.add(criteriaBuilder.like(root.get("name"), "%" + volunteerSearchDomain.getName() + "%"));
                }
                if (volunteerSearchDomain.getGender() != null && !volunteerSearchDomain.getGender().isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("gender"), volunteerSearchDomain.getGender()));
                }
                if(volunteerSearchDomain.getIsActive() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("isActive"), volunteerSearchDomain.getIsActive()));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };

        return volunteerRepository.findAll(queryCondition, pageable);
    }

    /**
     * 义工年龄段数据统计
     */
    public List<AgeGroupCountDTO> getAgeGroupCounts() {
        List<Date> birthdays = volunteerRepository.findAllBirthdays();
        Map<String, Integer> ageGroupCounts = initializeAgeGroups();

        for (Date birthday : birthdays) {
            int age = calculateAge(birthday);
            String ageGroup = determineAgeGroup(age);
            ageGroupCounts.put(ageGroup, ageGroupCounts.getOrDefault(ageGroup, 0) + 1);
        }

        return ageGroupCounts.entrySet().stream()
                .map(entry -> new AgeGroupCountDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    private Map<String, Integer> initializeAgeGroups() {
        Map<String, Integer> ageGroupCounts = new LinkedHashMap<>();
        ageGroupCounts.put("25-30", 0);
        ageGroupCounts.put("31-35", 0);
        ageGroupCounts.put("36-40", 0);
        ageGroupCounts.put("41-45", 0);
        ageGroupCounts.put("46-50", 0);
        ageGroupCounts.put("51-55", 0);
        ageGroupCounts.put("56-60", 0);
        ageGroupCounts.put("61-65", 0);
        ageGroupCounts.put("66-70", 0);
        ageGroupCounts.put("71-75", 0);
        ageGroupCounts.put("76-80", 0);
        ageGroupCounts.put("80+", 0);
        return ageGroupCounts;
    }

    private int calculateAge(Date birthday) {
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthday);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    private String determineAgeGroup(int age) {
        if (age >= 80) return "80+";
        if (age >= 76) return "76-80";
        if (age >= 71) return "71-75";
        if (age >= 66) return "66-70";
        if (age >= 61) return "61-65";
        if (age >= 56) return "56-60";
        if (age >= 51) return "51-55";
        if (age >= 46) return "46-50";
        if (age >= 41) return "41-45";
        if (age >= 36) return "36-40";
        if (age >= 31) return "31-35";
        if (age >= 25) return "25-30";
        return "Under 25";  // 这里可以根据你的需求添加更多年龄段
    }
}
