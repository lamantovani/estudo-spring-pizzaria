package com.lucascorp.pizzaria.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.lucascorp.pizzaria.model.entity.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {

}
