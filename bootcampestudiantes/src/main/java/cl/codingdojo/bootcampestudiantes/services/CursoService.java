package cl.codingdojo.bootcampestudiantes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.codingdojo.bootcampestudiantes.models.Curso;
import cl.codingdojo.bootcampestudiantes.models.PlanFormativo;
import cl.codingdojo.bootcampestudiantes.repositories.CursoRepository;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> allCursos() {
        return cursoRepository.findAll();
    }

    public PlanFormativo getCursoDescripcion(String codigo_curso) {
        return cursoRepository.getCursoDescripcion(codigo_curso);
    }

}
