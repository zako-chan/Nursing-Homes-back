package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.WifiInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WifiInfoRepository extends JpaRepository<WifiInfo, Long> {
}
