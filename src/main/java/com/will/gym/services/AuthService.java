package com.will.gym.services;

import com.will.gym.domain.User;
import com.will.gym.repositories.UserRepository;
import com.will.gym.services.dto.CreateLoginDTO;
import com.will.gym.services.dto.LoginCreatedDTO;
import com.will.gym.utils.exceptions.BusinessException;
import com.will.gym.utils.security.JwtUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import static com.will.gym.utils.logging.LogErrorId.LOGIN_ERROR;

@ApplicationScoped
public class AuthService {
    @Inject
    UserRepository userRepository;

    @Inject
    JwtUtils jwtUtils;

    public LoginCreatedDTO login(CreateLoginDTO createLoginDTO) {
        User user = userRepository.find("email", createLoginDTO.getEmail()).firstResult();
        if (user == null || !user.getPassword().equals(createLoginDTO.getPassword())) {
            throw new BusinessException(LOGIN_ERROR.getCode(),
                    LOGIN_ERROR.getDescription());
        }
        String jwt = jwtUtils.generateToken(user.getFirstName(), user.getEmail());
        return LoginCreatedDTO.builder().jwt(jwt).build();
    }
}
