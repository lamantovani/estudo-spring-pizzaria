package com.lucascorp.pizzaria.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucascorp.pizzaria.model.entity.Ingrediente;
import com.lucascorp.pizzaria.model.entity.Pizzaria;

@Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {
	
	public List<Ingrediente> findAllByDono(Pizzaria dono);
	
	public Ingrediente findByIdAndDono(Long id, Pizzaria dono);

}
