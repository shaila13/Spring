package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.repository.IPersonaRepo;
import com.mitocode.repository.PersonaRepoImpl;

@Service
public class PersonaServiceImpl implements IPersonaService {

	// Vamos a tener una instancia de la capa repository la capa de acceso a datos
	//Mediante la anotación autowired el framework busca una instancia definida en el contenedor spring
	@Autowired
	private IPersonaRepo repo;// Si solo dejamos esto va a cascar, nos falta el new, no metemos new @

	@Override
	public void registrar(String nombre) {
		//repo = new PersonaRepoImpl();//Al meter
		repo.registrar(nombre);

	}

}
