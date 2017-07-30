package com.lucascorp.pizzaria.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucascorp.pizzaria.exceptions.IngredienteInvalidoException;
import com.lucascorp.pizzaria.model.entity.Ingrediente;
import com.lucascorp.pizzaria.model.enumerador.CategoriaDeIngrediente;
import com.lucascorp.pizzaria.model.repository.IngredienteRepository;

@Controller
@RequestMapping("/ingredientes")
public class IngredientesController {

	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarIngredientes(Model model) {
		Iterable<Ingrediente> ingredientes = ingredienteRepository.findAll();
		
		model.addAttribute("titulo", "Listagem de Ingredientes");
		model.addAttribute("ingredientes", ingredientes);
		model.addAttribute("categorias", CategoriaDeIngrediente.values());
		return "ingrediente/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarIngrediente(
			@Valid
			@ModelAttribute Ingrediente ingrediente,
			BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
			
			throw new IngredienteInvalidoException();
			
//			FieldError error = bindingResult.getFieldErrors().get(0);
//			redirectAttributes.addFlashAttribute("mensagemErro", "Não foi possível salvar o Ingrediente " + error.getField() 
//			+  " " + error.getDefaultMessage());
			
		} else {
			ingredienteRepository.save(ingrediente);	
//			redirectAttributes.addFlashAttribute("mensagemInfo", "Ingrediente salvo com sucesso");
		}
		
		model.addAttribute("ingredientes", ingredienteRepository.findAll());
		model.addAttribute("categorias", CategoriaDeIngrediente.values());
		
//		return "redirect:/app/ingredientes";
		return "ingrediente/tabela-ingredientes";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarIngrediente(@PathVariable Long id) {
		try {
			ingredienteRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Ingrediente buscarIngrediente(@PathVariable Long id) {
		Ingrediente ingrediente = ingredienteRepository.findOne(id);
		return ingrediente;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
