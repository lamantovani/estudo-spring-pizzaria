package com.lucascorp.pizzaria.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucascorp.pizzaria.model.entity.Pizza;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long> {

}
