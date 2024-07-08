package com.example.ex3_2_back.domain.count;

import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EventSearchDomain {

    private Integer eventType;

    private Date eventDate;

    private Integer strangerId;
}
