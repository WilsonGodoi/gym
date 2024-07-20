package com.will.gym.mappers;

import com.will.gym.domain.Exercise;
import com.will.gym.services.dto.ExerciseCreatedDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(typeConversionPolicy = ReportingPolicy.ERROR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ExerciseMapper {
    List<ExerciseCreatedDTO> map(List<Exercise> exercises);
}
