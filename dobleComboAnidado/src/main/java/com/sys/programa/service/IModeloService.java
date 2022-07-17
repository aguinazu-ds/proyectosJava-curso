package com.sys.programa.service;

import java.util.List;

import com.sys.programa.entity.Modelo;

public interface IModeloService {
	
	List<Modelo> listarModelos();
	
	//Buscar por idMarca
	List<Modelo> buscarPorIdMarca(int idMarca);
	
}
