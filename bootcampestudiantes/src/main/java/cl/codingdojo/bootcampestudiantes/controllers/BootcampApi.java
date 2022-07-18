package cl.codingdojo.bootcampestudiantes.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.codingdojo.bootcampestudiantes.models.Comuna;
import cl.codingdojo.bootcampestudiantes.models.Estudiante;

import cl.codingdojo.bootcampestudiantes.repositories.BootcampApiRepository;

@RestController
@RequestMapping("/api")
class BootcampApiController {

    @Autowired
    BootcampApiRepository bootcampApiRepository;

    @GetMapping("/{codigo_region}/{codigo_curso}")
    public ResponseEntity<List<Estudiante>> getAll(@PathVariable("codigo_region") Integer codigo_region,
            @PathVariable("codigo_curso") String codigo_curso) {
        try {
            List<Estudiante> items = new ArrayList<Estudiante>();
            List<Comuna> comunasFiltradas = bootcampApiRepository.findAllComunaByRegion(codigo_region);

            for (Comuna comuna : comunasFiltradas) {
                items.addAll(bootcampApiRepository.findAllEstudiantesByCursoAndComuna(codigo_curso,
                        comuna.getCodigo_comuna()));
            }

            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Collections.sort(items);
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}