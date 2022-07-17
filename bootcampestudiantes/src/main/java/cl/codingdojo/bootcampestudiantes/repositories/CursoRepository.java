package cl.codingdojo.bootcampestudiantes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.codingdojo.bootcampestudiantes.models.Curso;
import cl.codingdojo.bootcampestudiantes.models.PlanFormativo;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {

    List<Curso> findAll();

    @Query("SELECT c.planformativo FROM Curso c WHERE codigo_curso = :codigo_curso")
    PlanFormativo getCursoDescripcion(@Param("codigo_curso") String codigo_curso);

}
