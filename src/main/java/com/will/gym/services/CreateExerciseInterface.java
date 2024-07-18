package com.will.gym.services;

import com.will.gym.domain.Exercise;
import com.will.gym.services.dto.CreateExerciseDTO;
import com.will.gym.services.dto.ExerciseCreatedDTO;

public interface CreateExerciseInterface {
    Exercise createExercise(final CreateExerciseDTO dto);
    ExerciseCreatedDTO getExerciseCreatedDTO(Exercise exercise);
}
