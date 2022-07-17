package com.sys.programa.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.programa.entity.Modelo;
import com.sys.programa.repository.ModeloRepository;
import com.sys.programa.service.IModeloService;

@Service
public class ModeloServiceImpl implements IModeloService {

	@Autowired
	private ModeloRepository modeloRepo;
	
	@Override
	public List<Modelo> listarModelos() {		
		return modeloRepo.findAll();
	}

	@Override
	public List<Modelo> buscarPorIdMarca(int idMarca) {		
		return modeloRepo.findByMarca_id(idMarca);
	}

}
