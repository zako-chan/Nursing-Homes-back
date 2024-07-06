package com.example.ex3_2_back.domain.wifiLocation;


import com.example.ex3_2_back.entity.WifiInfo;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class LocationData {
    Integer id;
    List<WifiInfo> wifiInfos;
}
