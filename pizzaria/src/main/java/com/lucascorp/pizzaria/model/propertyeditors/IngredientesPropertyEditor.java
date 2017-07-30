package com.lucascorp.pizzaria.model.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lucascorp.pizzaria.model.entity.Ingrediente;
import com.lucascorp.pizzaria.model.repository.IngredienteRepository;

@Component
public class IngredientesPropertyEditor extends PropertyEditorSupport{

	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idIngrediente = Long.parseLong(text);
		Ingrediente ingrediente = ingredienteRepository.findOne(idIngrediente);
		setValue(ingrediente);
	}
	
}
