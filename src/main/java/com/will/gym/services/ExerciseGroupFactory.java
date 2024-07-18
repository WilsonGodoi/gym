package com.will.gym.services;

import com.will.gym.utils.exceptions.BusinessException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import static com.will.gym.domain.ExerciseGroupType.CARDIO;
import static com.will.gym.utils.logging.LogErrorId.INVALID_EXERCISE_GROUP;

@ApplicationScoped
public class ExerciseGroupFactory {

    @Inject
    CreateExerciseCardioGroupService createExerciseCardioGroupService;

    private static BusinessException handleMarketException(String group) {
        final String errorDescription = String.format(INVALID_EXERCISE_GROUP.getDescription(), group);
        return new BusinessException(INVALID_EXERCISE_GROUP.getCode(), errorDescription);
    }

    public CreateExerciseInterface getExerciseByGroup(String group) {
        if (CARDIO.name().equals(group)) {
            return this.createExerciseCardioGroupService;
        }
        throw handleMarketException(group);
    }
}
