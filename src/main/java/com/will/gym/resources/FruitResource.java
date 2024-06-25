package com.will.gym.resources;

import java.util.List;

import com.will.gym.domain.Fruit;
import com.will.gym.repositories.FruitRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/fruits")
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
