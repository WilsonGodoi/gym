package com.will.gym.repositories;

import com.will.gym.domain.Fruit;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {
}
