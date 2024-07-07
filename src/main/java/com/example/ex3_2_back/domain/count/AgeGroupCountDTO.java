package com.example.ex3_2_back.domain.count;

public class AgeGroupCountDTO {
    private String ageGroup;
    private int count;

    public AgeGroupCountDTO(String ageGroup, int count) {
        this.ageGroup = ageGroup;
        this.count = count;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}