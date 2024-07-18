package com.will.gym.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private String exerciseGroupType;

    @NotNull(message = "Exercise Type can't be null")
    private String exerciseType;
}
