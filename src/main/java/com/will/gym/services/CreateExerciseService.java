package com.will.gym.services;

import com.will.gym.services.dto.CreateExerciseDTO;
import com.will.gym.services.dto.ExerciseCreatedDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateExerciseService {

    public ExerciseCreatedDTO createExercise(CreateExerciseDTO createExerciseDTO) {
//        if (createUserDTO.getConfirmationPassword() == null || !createUserDTO.getConfirmationPassword().equals(createUserDTO.getPassword())) {
//            throw new BusinessException(CONFIRMATION_PASSWORD_ERROR.getCode(),
//                    String.format(CONFIRMATION_PASSWORD_ERROR.getDescription(), createUserDTO.getEmail(), createUserDTO.getFirstName()));
//        }
//        User user = mapper.map(createUserDTO);
//        try {
//            userRepository.persistAndFlush(user);
//        } catch (PersistenceException ex) {
//            throw new BusinessException(PERSISTENCE_ERROR.getCode(),
//                    String.format(PERSISTENCE_ERROR.getDescription(), createUserDTO.getEmail(), createUserDTO.getFirstName()));
//        }
        return new ExerciseCreatedDTO();
    }
}
