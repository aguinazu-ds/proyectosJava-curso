package cl.codingdojo.bootcampestudiantes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.codingdojo.bootcampestudiantes.models.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer> {
    @Query("SELECT c FROM Comuna c WHERE codigo_region = :codigo_region")
    List<Comuna> findAllComunaByRegion(@Param("codigo_region") Integer codigo_region);
}
