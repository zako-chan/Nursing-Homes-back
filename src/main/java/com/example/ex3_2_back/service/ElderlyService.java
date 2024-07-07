package com.example.ex3_2_back.service;


import com.example.ex3_2_back.domain.count.AgeGroupCountDTO;
import com.example.ex3_2_back.domain.count.EventCountDTO;
import com.example.ex3_2_back.domain.elderly.ElderlySearchDomain;
import com.example.ex3_2_back.entity.Elderly;
import com.example.ex3_2_back.exception.ResourceAlreadyExistsException;
import com.example.ex3_2_back.exception.ResourceNotExistException;
import com.example.ex3_2_back.repository.ElderlyRepository;
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
        Optional<Elderly> elderlyByIdCard = elderlyRepository.findByIdCard(elderly.getIdCard());
        if (elderlyByIdCard.isPresent()) {
            throw new ResourceAlreadyExistsException("身份证号已存在");
        }
        Elderly elderly1 = elderlyRepository.save(elderly);
        return elderly1.getId();
    }

    /**
     * 修改老人信息
     */
    public void updateElderly(Elderly elderly) {
        Optional<Elderly> elderlyBefore = elderlyRepository.findById(elderly.getId());
        if (elderlyBefore.isPresent()) {
            Elderly elderly1 = elderlyBefore.get();
            UpdateUtil.copyNotNullProperties(elderly, elderly1);
            elderlyRepository.save(elderly1);
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

    /**
     * 根据查询条件查找老人
     */
    public Page<Elderly> searchElderlyDynamic(ElderlySearchDomain elderlySearchDomain, Pageable pageable) {
        Specification<Elderly> queryCondition = new Specification<Elderly>() {
            @Override
            public Predicate toPredicate(Root<Elderly> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (elderlySearchDomain.getUsername() != null && !elderlySearchDomain.getUsername().isEmpty()) {
                    predicateList.add(criteriaBuilder.like(root.get("username"), "%" + elderlySearchDomain.getUsername() + "%"));
                }
                if (elderlySearchDomain.getGender() != null && !elderlySearchDomain.getGender().isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("gender"), elderlySearchDomain.getGender()));
                }
                if (elderlySearchDomain.getRoomNumber()!= null && !elderlySearchDomain.getRoomNumber().isEmpty()) {
                    predicateList.add(criteriaBuilder.like(root.get("roomNumber"), "%" + elderlySearchDomain.getRoomNumber() + "%" ));
                }
                if (elderlySearchDomain.getHealthState() != null && !elderlySearchDomain.getHealthState().isEmpty()) {
                    predicateList.add(criteriaBuilder.like(root.get("healthState"), elderlySearchDomain.getHealthState()));
                }
                if(elderlySearchDomain.getIsActive() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("isActive"), elderlySearchDomain.getIsActive()));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };

        return elderlyRepository.findAll(queryCondition, pageable);
    }

    /**
     * 老人年龄段数据统计
     */
    public List<AgeGroupCountDTO> getAgeGroupCounts() {
        List<Date> birthdays = elderlyRepository.findAllBirthdays();
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
