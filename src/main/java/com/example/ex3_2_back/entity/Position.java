package com.example.ex3_2_back.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


/**
 * 位置信息
 */
@Entity
@Table(name = "position")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;

    private double x;

    private double y;

    private double z;

    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<WifiInfo> wifiInfos;

    public Position(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString(){
        return "id:"+id+" x:"+x+" y:"+y+" z:"+z;
    }
}
