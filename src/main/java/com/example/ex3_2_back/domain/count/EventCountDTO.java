package com.example.ex3_2_back.domain.count;


import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EventCountDTO {
    private String eventName;
    private int count;
}
