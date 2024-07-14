package com.will.gym.resources;

import com.will.gym.services.CreateUserService;
import com.will.gym.services.dto.CreateUserDTO;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
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

    @GET
    @Authenticated
    public Response getUser() {
        return Response.status(HttpStatus.SC_OK)
                .entity(createUserService.getUser())
                .build();
    }
}
