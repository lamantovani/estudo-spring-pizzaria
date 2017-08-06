package com.lucascorp.pizzaria.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.lucascorp.pizzaria.model.entity.Pizzaria;
import com.lucascorp.pizzaria.model.repository.PizzariaRepository;

@Service
public class ServicoPizzaria {
	
	@Autowired
	private PizzariaRepository pizzariaRepository;
	
	public Pizzaria getPizzariaLogada() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null) throw new AuthenticationCredentialsNotFoundException("Usuário não logado");
		UserDetails usuarioLogado = (UserDetails) authentication.getPrincipal();
		return pizzariaRepository.findOneByLogin(usuarioLogado.getUsername());
	}

}
