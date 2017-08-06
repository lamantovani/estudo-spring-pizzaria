package com.lucascorp.pizzaria.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucascorp.pizzaria.model.entity.Pizzaria;

@Repository
public interface PizzariaRepository extends CrudRepository<Pizzaria, Long> {

	@Query("SELECT p FROM Pizzaria p WHERE p.usuario.login = ?")
	public Pizzaria findOneByLogin(String login);
	
	@Query("SELECT p1 FROM Pizzaria p1 INNER JOIN p1.pizzas p2 WHERE p2.nome = ?")
	public List<Pizzaria> listarPizzariasQueContem(String nomePizza);
	
	
}
