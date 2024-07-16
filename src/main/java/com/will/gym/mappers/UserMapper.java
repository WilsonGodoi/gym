package com.will.gym.mappers;

import com.will.gym.domain.User;
import com.will.gym.services.dto.CreateUserDTO;
import com.will.gym.services.dto.UserCreatedDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.time.ZoneId;

@Mapper(typeConversionPolicy = ReportingPolicy.ERROR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        imports = {ZoneId.class})
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User map(CreateUserDTO dto);


    UserCreatedDTO map(User user);
}
