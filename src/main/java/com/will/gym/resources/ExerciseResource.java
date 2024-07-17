package com.will.gym.resources;

import com.will.gym.services.CreateExerciseService;
import com.will.gym.services.dto.CreateExerciseDTO;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.http.HttpStatus;

@Path("exercise")
public class ExerciseResource {

    @Inject
    CreateExerciseService createExerciseService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createExercise(@Valid CreateExerciseDTO dto) {
        return Response.status(HttpStatus.SC_CREATED)
                .entity(createExerciseService.createExercise(dto))
                .build();
    }
}
