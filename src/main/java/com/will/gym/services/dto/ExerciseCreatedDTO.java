package com.will.gym.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExerciseCreatedDTO {
    private Long id;
    private String exerciseGroupType;
    private String exerciseType;
    private Integer distance;
    private Integer time;
    private Double averageSpeed;
}
