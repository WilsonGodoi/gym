package com.will.gym.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.will.gym.domain.ExerciseGroupType;
import com.will.gym.domain.ExerciseType;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExerciseCreatedDTO {
    private Long id;
    private ExerciseGroupType exerciseGroupType;
    private ExerciseType exerciseType;
}
