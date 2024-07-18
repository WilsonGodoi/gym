package com.will.gym.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.will.gym.domain.ExerciseGroupType;
import com.will.gym.domain.ExerciseType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateExerciseDTO {
    @NotNull(message = "Exercise Group Type can't be null")
    private ExerciseGroupType exerciseGroupType;

    @NotNull(message = "Exercise Type can't be null")
    private ExerciseType exerciseType;
}
