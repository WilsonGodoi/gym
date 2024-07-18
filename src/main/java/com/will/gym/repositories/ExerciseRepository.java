package com.will.gym.repositories;

import com.will.gym.domain.Exercise;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExerciseRepository implements PanacheRepositoryBase<Exercise, String> {
}
