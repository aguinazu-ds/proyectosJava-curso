package com.sys.programa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sys.programa.entity.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

	//Metodo para buscar modelos de auto, segun del idMarca
	List<Modelo> findByMarca_id(int idMarca);
	
}
