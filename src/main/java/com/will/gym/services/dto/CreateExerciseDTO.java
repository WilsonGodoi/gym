package com.will.gym.services.dto;

import org.hibernate.validator.constraints.Range;

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

    @Range(min = 1, message = "Invalid distance in meters")
    private Integer distanceInMeters;

    @Range(min = 1, message = "Invalid time in minutes")
    private Integer timeInSeconds;
}
