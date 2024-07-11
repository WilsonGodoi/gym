package com.will.gym.services;

import com.will.gym.domain.User;
import com.will.gym.mappers.UserMapper;
import com.will.gym.repositories.UserRepository;
import com.will.gym.services.dto.CreateUserDTO;
import com.will.gym.services.dto.UserCreatedDTO;
import com.will.gym.utils.exceptions.BusinessException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;

import static com.will.gym.utils.logging.LogErrorId.CONFIRMATION_PASSWORD_ERROR;
import static com.will.gym.utils.logging.LogErrorId.PERSISTENCE_ERROR;

@ApplicationScoped
public class CreateUserService {

    @Inject
    UserMapper mapper;

    @Inject
    UserRepository userRepository;

    public UserCreatedDTO createUser(CreateUserDTO createUserDTO) {
        if (createUserDTO.getConfirmationPassword() == null || !createUserDTO.getConfirmationPassword().equals(createUserDTO.getPassword())) {
            throw new BusinessException(CONFIRMATION_PASSWORD_ERROR.getCode(),
                    String.format(CONFIRMATION_PASSWORD_ERROR.getDescription(), createUserDTO.getEmail(), createUserDTO.getFirstName()));
        }
        User user = mapper.map(createUserDTO);
        try {
            userRepository.persistAndFlush(user);
        } catch (PersistenceException ex) {
            throw new BusinessException(PERSISTENCE_ERROR.getCode(),
                    String.format(PERSISTENCE_ERROR.getDescription(), createUserDTO.getEmail(), createUserDTO.getFirstName()));
        }
        return mapper.map(user);
    }
}
