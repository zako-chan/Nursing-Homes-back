package com.example.ex3_2_back.domain.wifiLocation;


import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ElderlyPosition {
    Integer id;
    double x;
    double y;
    double z;
}
