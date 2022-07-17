package com.sys.programa.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.programa.entity.Marca;
import com.sys.programa.repository.MarcaRepository;
import com.sys.programa.service.IMarcaService;

@Service
public class MarcaServiceImpl implements IMarcaService {

	@Autowired
	private MarcaRepository marcaRepo;
	
	@Override
	public List<Marca> listarMarcas() {
		
		return marcaRepo.findAll();
	}

}
