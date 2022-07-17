package cl.codingdojo.bootcampestudiantes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.codingdojo.bootcampestudiantes.models.Comuna;
import cl.codingdojo.bootcampestudiantes.repositories.ComunaRepository;

@Service
public class ComunaService {
    private final ComunaRepository comunaRepository;

    public ComunaService(ComunaRepository comunaRepository) {
        this.comunaRepository = comunaRepository;
    }

    public List<Comuna> findComunasByRegion(Integer codigo_region) {
        return comunaRepository.findAllComunaByRegion(codigo_region);
    }

}
