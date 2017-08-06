package com.lucascorp.pizzaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucascorp.pizzaria.model.services.ServicoPizza;

@Controller
@RequestMapping("/pizzarias")
public class PizzariaController {

	@Autowired private ServicoPizza servicoPizza;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("nomesPizzas", servicoPizza.listarNomePizzasDisponiveis());
		return "cliente/buscar_pizzarias";
	}
	
}
