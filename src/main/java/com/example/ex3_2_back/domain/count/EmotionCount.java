package com.example.ex3_2_back.domain.count;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EmotionCount {
    private String emotion;
    private int count;
}
