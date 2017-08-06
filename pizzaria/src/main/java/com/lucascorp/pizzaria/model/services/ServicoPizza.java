package com.lucascorp.pizzaria.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucascorp.pizzaria.model.entity.Pizza;
import com.lucascorp.pizzaria.model.entity.Pizzaria;
import com.lucascorp.pizzaria.model.repository.PizzaRepository;


@Service
public class ServicoPizza {
	
	@Autowired
	private ServicoPizzaria servicoPizzaria;
	
	@Autowired
	private PizzaRepository repositorio;
	
	public void salvar(Pizza pizza) {
		pizza.setDono(servicoPizzaria.getPizzariaLogada());
		repositorio.save(pizza);
	}
	
	public Iterable<Pizza> listar(){
		Pizzaria dono = servicoPizzaria.getPizzariaLogada();
		return repositorio.findAllByDono(dono);
	}
	
	public Pizza buscar(long id) {
		Pizzaria dono = servicoPizzaria.getPizzariaLogada();
		return repositorio.findByIdAndDono(id, dono);
	}
	
	public void remover(long id) {
		Pizza pizza = this.buscar(id);
		if(pizza != null) repositorio.delete(pizza);
	}

	public List<String> listarNomePizzasDisponiveis() {
		List<Pizza> pizzas = repositorio.findAll();
		
		List<String> nomesPizzarias = pizzas.stream().map((pizza) ->{
			return pizza.getNome();
		}).sorted().collect(Collectors.toList());
		
		return nomesPizzarias;
		
	}
	
}
