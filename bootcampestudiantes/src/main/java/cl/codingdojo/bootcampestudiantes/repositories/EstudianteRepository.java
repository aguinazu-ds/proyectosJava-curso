package cl.codingdojo.bootcampestudiantes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.codingdojo.bootcampestudiantes.models.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    @Query("SELECT e FROM Estudiante e WHERE codigo_curso = :codigo_curso AND codigo_comuna = :codigo_comuna ")
    List<Estudiante> findAllEstudiantesByCursoAndComuna(@Param("codigo_curso") String codigo_curso,
            @Param("codigo_comuna") Integer codigo_comuna);
}
