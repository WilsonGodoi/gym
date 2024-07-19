package com.will.gym.mappers;


import com.will.gym.domain.Exercise;
import com.will.gym.services.dto.CreateExerciseDTO;
import com.will.gym.services.dto.ExerciseCreatedDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(typeConversionPolicy = ReportingPolicy.ERROR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ExerciseCardioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "averageSpeed", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    Exercise map(CreateExerciseDTO dto);

    ExerciseCreatedDTO map(Exercise exercise);
}
