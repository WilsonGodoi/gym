package com.will.gym.services;

import com.will.gym.domain.Exercise;
import com.will.gym.mappers.ExerciseCardioMapper;
import com.will.gym.services.dto.CreateExerciseDTO;
import com.will.gym.services.dto.ExerciseCreatedDTO;
import com.will.gym.utils.exceptions.BusinessException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import static com.will.gym.utils.logging.LogErrorId.INVALID_TIME_IN_MINUTES_AND_DISTANCE_IN_METERS;

@ApplicationScoped
public class CreateExerciseCardioGroupService implements CreateExerciseInterface {

    @Inject
    ExerciseCardioMapper mapper;

    @Override
    public Exercise createExercise(CreateExerciseDTO dto) {
        validateDTO(dto);
        Exercise exercise = mapper.map(dto);
        calculateAverageSpeed(dto, exercise);
        return exercise;
    }

    @Override
    public ExerciseCreatedDTO getExerciseCreatedDTO(Exercise exercise) {
        return mapper.map(exercise);
    }

    private void validateDTO(CreateExerciseDTO dto) {
        if ((dto.getTime() == null)
                && (dto.getDistance() == null)) {
            throw new BusinessException(INVALID_TIME_IN_MINUTES_AND_DISTANCE_IN_METERS.getCode(),
                    INVALID_TIME_IN_MINUTES_AND_DISTANCE_IN_METERS.getDescription());
        }
    }

    private void calculateAverageSpeed(CreateExerciseDTO dto, Exercise exercise) {
        if (dto.getTime() != null && dto.getDistance() != null) {
            Double averageSpeed = (double) dto.getDistance() / (double) dto.getTime();
            exercise.setAverageSpeed(averageSpeed);
        }
    }
}
