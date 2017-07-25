package com.lucascorp.pizzaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucascorp.pizzaria.model.repository.PizzaRepository;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@RequestMapping("/quandidade")
	@ResponseBody
	public String quantidadePizza() {
		return "Atualmente a quantidade é: " + pizzaRepository.count() + " cadastradp";
	}
	
}
