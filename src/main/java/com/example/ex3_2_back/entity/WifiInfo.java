package com.example.ex3_2_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wifi_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WifiInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;

    private String bssid;

//    private String ssid;

    private double level;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

}
