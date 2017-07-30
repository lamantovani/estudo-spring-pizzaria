package com.lucascorp.pizzaria.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucascorp.pizzaria.exceptions.IngredienteInvalidoException;
import com.lucascorp.pizzaria.model.entity.Ingrediente;
import com.lucascorp.pizzaria.model.entity.Pizza;
import com.lucascorp.pizzaria.model.enumerador.CategoriaDePizza;
import com.lucascorp.pizzaria.model.propertyeditors.IngredientesPropertyEditor;
import com.lucascorp.pizzaria.model.repository.IngredienteRepository;
import com.lucascorp.pizzaria.model.repository.PizzaRepository;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired
	private  IngredienteRepository ingredienteRepository;
	
	@Autowired
	private IngredientesPropertyEditor ingredientePropertyEditor;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarPizzas(Model model) {
		model.addAttribute("pizzas", pizzaRepository.findAll());
		model.addAttribute("categorias", CategoriaDePizza.values());
		model.addAttribute("ingredientes", ingredienteRepository.findAll());
		return "pizza/listagem";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<Pizza> buscarPizza(@PathVariable Long id){
		Pizza pizza = pizzaRepository.findOne(id);
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarPizza(@PathVariable Long id){
		try {
			pizzaRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarPizza(
			Model model,
			@Valid @ModelAttribute Pizza pizza,
			BindingResult bingingResult){
		
		if(bingingResult.hasErrors()) {
			throw new IngredienteInvalidoException();
		} else {
			pizzaRepository.save(pizza);
		}
		
		model.addAttribute("pizzas", pizzaRepository.findAll());
		return "pizza/tabela-pizzas";
	}
	
	@RequestMapping("/quandidade")
	@ResponseBody
	public String quantidadePizza() {
		return "Atualmente a quantidade é: " + pizzaRepository.count() + " cadastradp";
	}
	
	@InitBinder
	public void intiBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Ingrediente.class, ingredientePropertyEditor);
	}
	
}
