package com.will.gym.resources;

import com.will.gym.domain.Fruit;
import com.will.gym.repositories.FruitRepository;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/fruits")
@Authenticated
public class FruitResource {


    @Inject
    FruitRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> list() {
        return repository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void add(Fruit fruit) {

        repository.persist(fruit);
    }
}
