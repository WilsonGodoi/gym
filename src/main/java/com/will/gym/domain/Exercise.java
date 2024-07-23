package com.will.gym.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "exercise")
@NamedQuery(name = "Exercise.getByEmail",
        query = "FROM Exercise e WHERE e.email = :email ORDER BY e.createdAt DESC")
public class Exercise extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExerciseGroupType exerciseGroupType;

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

    @Email
    private String email;

    private Integer distanceInMeters;
    private Integer timeInSeconds;
    private Double averageSpeedKmPerHour;
    private Instant createdAt;
}
