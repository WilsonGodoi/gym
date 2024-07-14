package com.will.gym.resources;

import com.will.gym.services.AuthService;
import com.will.gym.services.dto.CreateLoginDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.http.HttpStatus;

@Path("auth")
public class AuthResource {

    @Inject
    AuthService authService;

    @Path("login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response login(@Valid CreateLoginDTO createLoginDTO) {
        return Response.status(HttpStatus.SC_OK)
                .entity(authService.login(createLoginDTO))
                .build();
    }
}
