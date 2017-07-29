package com.lucascorp.pizzaria.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			
			FieldError error = bindingResult.getFieldErrors().get(0);
			redirectAttributes.addFlashAttribute("mensagemErro", "Não foi possível salvar o Ingrediente " + error.getField() 
			+  " " + error.getDefaultMessage());
			
		} else {
			ingredienteRepository.save(ingrediente);	
			redirectAttributes.addFlashAttribute("mensagemInfo", "Ingrediente salvo com sucesso");
		}
		
		return "redirect:/app/ingredientes";
	}
	
}
