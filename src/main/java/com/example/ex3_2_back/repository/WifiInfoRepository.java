package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Position;
import com.example.ex3_2_back.entity.WifiInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface WifiInfoRepository extends JpaRepository<WifiInfo, Integer> {

    Set<WifiInfo> getWifiInfoByPosition(Position position);
}
