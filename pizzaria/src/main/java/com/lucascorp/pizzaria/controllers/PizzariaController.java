package com.lucascorp.pizzaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucascorp.pizzaria.model.services.ServicoPizza;
import com.lucascorp.pizzaria.model.services.ServicoPizzaria;

@Controller
@RequestMapping("/pizzarias")
public class PizzariaController {

	@Autowired private ServicoPizza servicoPizza;
	@Autowired private ServicoPizzaria servicoPizzaria;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("nomesPizzas", servicoPizza.listarNomePizzasDisponiveis());
		return "cliente/buscar_pizzarias";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/pizza/{nomePizza}")
	public String index(@PathVariable String nomePizza, Model model) {
		model.addAttribute("pizzarias", servicoPizzaria.listarPizzariasQueContem(nomePizza));
		return "cliente/tabela_pizzarias";
	}
	
}
