package com.example.ex3_2_back.domain.count;

import com.example.ex3_2_back.entity.Volunteer;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Interaction {

    Volunteer volunteer;
    Long count;
}
