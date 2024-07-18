package com.will.gym.services;

import com.will.gym.domain.Exercise;
import com.will.gym.mappers.ExerciseCardioMapper;
import com.will.gym.services.dto.CreateExerciseDTO;
import com.will.gym.services.dto.ExerciseCreatedDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CreateExerciseCardioGroupService implements CreateExerciseInterface {

    @Inject
    ExerciseCardioMapper mapper;

    @Override
    public Exercise createExercise(CreateExerciseDTO dto) {
        return mapper.map(dto);
    }

    @Override
    public ExerciseCreatedDTO getExerciseCreatedDTO(Exercise exercise) {
        return mapper.map(exercise);
    }


}
