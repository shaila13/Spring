package com.capgemini.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.springboot.backend.apirest.models.dao.IClienteDao;
import com.capgemini.springboot.backend.apirest.models.entity.Cliente;

@Service
public class ClienteServiceImp implements IClienteService{
	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {

		return clienteDao.findById(id).orElse(null);
	}
	@Override
	@Transactional(readOnly = true)
	public Cliente save(Cliente cliente) {

		return clienteDao.save(cliente);
	}
	@Override
	@Transactional(readOnly = true)
	public void delete(Long id) {
		clienteDao.deleteById(id);
		
	}

}
