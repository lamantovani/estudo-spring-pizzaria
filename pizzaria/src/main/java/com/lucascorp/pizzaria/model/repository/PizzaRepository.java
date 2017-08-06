package com.lucascorp.pizzaria.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucascorp.pizzaria.model.entity.Pizza;
import com.lucascorp.pizzaria.model.entity.Pizzaria;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long> {
	
	public List<Pizza> findAllByDono(Pizzaria dono);
	
	public Pizza findByIdAndDono(Long id, Pizzaria dono);
	
	public List<Pizza> findAll(Sort sort);

}
