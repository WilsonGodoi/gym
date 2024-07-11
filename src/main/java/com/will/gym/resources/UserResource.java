package com.will.gym.resources;

import com.will.gym.domain.User;
import com.will.gym.repositories.UserRepository;
import com.will.gym.services.CreateUserService;
import com.will.gym.services.dto.CreateUserDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.http.HttpStatus;

@Path("/users")
public class UserResource {

    @Inject
    CreateUserService createUserService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createUser(@Valid CreateUserDTO createUserDTO) {
        return Response.status(HttpStatus.SC_CREATED)
                .entity(createUserService.createUser(createUserDTO))
                .build();
    }
}
