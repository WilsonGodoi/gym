package com.will.gym.services;

import com.will.gym.domain.ExerciseGroupType;
import com.will.gym.utils.exceptions.BusinessException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import static com.will.gym.domain.ExerciseGroupType.CARDIO;
import static com.will.gym.utils.logging.LogErrorId.INVALID_EXERCISE_GROUP;

@ApplicationScoped
public class ExerciseGroupFactory {

    @Inject
    CreateExerciseCardioGroupService createExerciseCardioGroupService;

    private static BusinessException handleMarketException(ExerciseGroupType group) {
        final String errorDescription = String.format(INVALID_EXERCISE_GROUP.getDescription(), group.name());
        return new BusinessException(INVALID_EXERCISE_GROUP.getCode(), errorDescription);
    }

    public CreateExerciseInterface getExerciseByGroup(ExerciseGroupType group) {
        if (CARDIO.name().equals(group.name())) {
            return this.createExerciseCardioGroupService;
        }
        throw handleMarketException(group);
    }
}
