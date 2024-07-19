package com.will.gym.services;

import com.will.gym.domain.Exercise;
import com.will.gym.repositories.ExerciseRepository;
import com.will.gym.services.dto.CreateExerciseDTO;
import com.will.gym.services.dto.ExerciseCreatedDTO;
import com.will.gym.utils.exceptions.BusinessException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import org.eclipse.microprofile.jwt.JsonWebToken;

import static com.will.gym.utils.logging.LogErrorId.PERSISTENCE_ERROR;

@ApplicationScoped
public class CreateExerciseService {

    @Inject
    ExerciseGroupFactory exerciseGroupFactory;

    @Inject
    ExerciseRepository exerciseRepository;

    public ExerciseCreatedDTO createExercise(CreateExerciseDTO createExerciseDTO, JsonWebToken jwt) {
        Exercise exercise = exerciseGroupFactory.getExerciseByGroup(createExerciseDTO.getExerciseGroupType())
                .createExercise(createExerciseDTO);
        exercise.setEmail(jwt.getSubject());
        try {
            exerciseRepository.persistAndFlush(exercise);
        } catch (PersistenceException ex) {
            throw new BusinessException(PERSISTENCE_ERROR.getCode(),
                    PERSISTENCE_ERROR.getDescription());
        }
        return exerciseGroupFactory.getExerciseByGroup(createExerciseDTO.getExerciseGroupType())
                .getExerciseCreatedDTO(exercise);
    }
}
