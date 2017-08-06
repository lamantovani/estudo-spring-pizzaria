package com.lucascorp.pizzaria.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucascorp.pizzaria.model.entity.Ingrediente;
import com.lucascorp.pizzaria.model.entity.Pizzaria;
import com.lucascorp.pizzaria.model.repository.IngredienteRepository;


@Service
public class ServicoIngrediente {
	
	@Autowired
	private ServicoPizzaria servicoPizzaria;
	
	@Autowired
	private IngredienteRepository repositorio;
	
	public void salvar(Ingrediente ingrediente) {
		ingrediente.setDono(servicoPizzaria.getPizzariaLogada());
		repositorio.save(ingrediente);
	}
	
	public Iterable<Ingrediente> listar(){
		Pizzaria dono = servicoPizzaria.getPizzariaLogada();
		return repositorio.findAllByDono(dono);
	}
	
	public Ingrediente buscar(long id) {
		Pizzaria dono = servicoPizzaria.getPizzariaLogada();
		return repositorio.findByIdAndDono(id, dono);
	}
	
	public void remover(long id) {
		Ingrediente ingrediente = this.buscar(id);
		if(ingrediente != null) repositorio.delete(ingrediente);
	}
	
}
