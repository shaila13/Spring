package com.capgemini.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.backend.apirest.models.entity.Cliente;
import com.capgemini.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	private ResponseEntity	respuesta ;
	private final static Logger LOGGER = Logger.getLogger(Cliente.class.getName());
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clienteService.findAll();
	}
	@GetMapping("/clientes/{id}")
	//@ResponseStatus(HttpStatus.OK) SE CREA POR DEFECTO
	public ResponseEntity<?> show(@PathVariable Long id) {
		Cliente	cliente=null;
		
		Map<String, Object> response = new HashMap<>();
		
	try  {
		cliente = clienteService.findById(id);
		respuesta = new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}catch (DataAccessException e) {
		response.put("mensaje", "El cliente ID ".concat(id.toString().concat(" no existe en la base de datos!")));
		respuesta =  new ResponseEntity<Map<String, Object>>( response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	return respuesta;
	
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Cliente cliente) {
	
		
		Map<String, Object> response = new HashMap<>();
		Cliente clienteNew = null;
		
		try  {
			clienteNew = clienteService.save(cliente);
			response.put("mensaje", "Se ha actualizado el cliente!");
			response.put("cliente", clienteNew);
			respuesta = new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos!");
			respuesta =  new ResponseEntity<Map<String, Object>>( response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return respuesta;
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente,@PathVariable Long id) {
		
		Cliente clienteActual= clienteService.findById(id);
		
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setEmail(cliente.getEmail());
		
		return clienteService.save(clienteActual);
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		 clienteService.delete(id);
	}
	
}
