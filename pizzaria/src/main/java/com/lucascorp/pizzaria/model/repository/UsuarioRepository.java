package com.lucascorp.pizzaria.model.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucascorp.pizzaria.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	public Usuario findOneByLogin(String login);
	
	
}
