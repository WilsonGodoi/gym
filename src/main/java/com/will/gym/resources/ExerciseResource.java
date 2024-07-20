package com.will.gym.resources;

import org.apache.http.HttpStatus;
import org.eclipse.microprofile.jwt.JsonWebToken;

import com.will.gym.services.CreateExerciseService;
import com.will.gym.services.dto.CreateExerciseDTO;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("exercise")
public class ExerciseResource {

    @Inject
    CreateExerciseService createExerciseService;

    @Inject
    JsonWebToken jwt;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createExercise(@Valid CreateExerciseDTO dto) {
        return Response.status(HttpStatus.SC_CREATED)
                .entity(createExerciseService.createExercise(dto, jwt))
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExercises() {
        return Response.status(HttpStatus.SC_OK)
                .entity(createExerciseService.getExercises(jwt))
                .build();

    }
}
