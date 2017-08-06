package com.lucascorp.pizzaria.model.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucascorp.pizzaria.model.entity.Pizzaria;

@Repository
public interface PizzariaRepository extends CrudRepository<Pizzaria, Long> {

	public Pizzaria findOneByLogin(String login);
	
	
}
