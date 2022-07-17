package cl.codingdojo.bootcampestudiantes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.codingdojo.bootcampestudiantes.models.Estudiante;
import cl.codingdojo.bootcampestudiantes.repositories.EstudianteRepository;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> findEstudiantesByCursoYRegion(String codigo_curso, Integer codigo_comuna) {
        return estudianteRepository.findAllEstudiantesByCursoAndComuna(codigo_curso, codigo_comuna);
    }
}
