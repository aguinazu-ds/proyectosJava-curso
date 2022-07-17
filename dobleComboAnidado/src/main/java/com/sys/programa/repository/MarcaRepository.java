package com.sys.programa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sys.programa.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
