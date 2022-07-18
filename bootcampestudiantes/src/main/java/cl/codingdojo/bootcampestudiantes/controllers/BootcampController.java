package cl.codingdojo.bootcampestudiantes.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.codingdojo.bootcampestudiantes.models.Comuna;
import cl.codingdojo.bootcampestudiantes.models.Curso;
import cl.codingdojo.bootcampestudiantes.models.Estudiante;
import cl.codingdojo.bootcampestudiantes.models.FiltroRegionCurso;
import cl.codingdojo.bootcampestudiantes.models.Region;
import cl.codingdojo.bootcampestudiantes.services.ComunaService;
import cl.codingdojo.bootcampestudiantes.services.CursoService;
import cl.codingdojo.bootcampestudiantes.services.EstudianteService;
import cl.codingdojo.bootcampestudiantes.services.RegionService;

@Controller
public class BootcampController {
    private final CursoService cursoService;
    private final RegionService regionService;
    private final ComunaService comunaService;
    private final EstudianteService estudianteService;

    public BootcampController(CursoService cursoService, RegionService regionService, ComunaService comunaService,
            EstudianteService estudianteService) {
        this.cursoService = cursoService;
        this.regionService = regionService;
        this.comunaService = comunaService;
        this.estudianteService = estudianteService;
    }

    @RequestMapping("/")
    public String showTable(Model model,
            @Validated @ModelAttribute("filtroRegionCurso") FiltroRegionCurso filtroRegionCurso) {
        List<Region> regiones = regionService.allRegiones();
        List<Curso> cursos = cursoService.allCursos();
        model.addAttribute("regiones", regiones);
        model.addAttribute("cursos", cursos);
        return "home";
    }

    @PostMapping("/")
    public String filterTable(Model model,
            @Validated @ModelAttribute("filtroRegionCurso") FiltroRegionCurso filtroRegionCurso) {
        Integer codigo_region = filtroRegionCurso.getCodigo_region();
        String codigo_curso = filtroRegionCurso.getCodigo_curso();
        String descripcion_curso = cursoService.getCursoDescripcion(codigo_curso).getDescripcion();

        List<Region> regiones = regionService.allRegiones();
        List<Curso> cursos = cursoService.allCursos();
        List<Comuna> comunasFiltradas = comunaService.findComunasByRegion(codigo_region);
        List<Estudiante> estudiantesFiltrados = new ArrayList<>();

        for (Comuna comuna : comunasFiltradas) {
            estudiantesFiltrados
                    .addAll(estudianteService.findEstudiantesByCursoYRegion(codigo_curso, comuna.getCodigo_comuna()));
        }
        Collections.sort(estudiantesFiltrados);
        model.addAttribute("estudiantesFiltrados", estudiantesFiltrados);
        model.addAttribute("codigo_curso", codigo_curso);
        model.addAttribute("regiones", regiones);
        model.addAttribute("cursos", cursos);
        model.addAttribute("descripcion_curso", descripcion_curso);
        return "home";
    }
}
