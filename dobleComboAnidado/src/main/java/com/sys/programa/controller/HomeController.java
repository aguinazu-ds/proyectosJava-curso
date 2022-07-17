package com.sys.programa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.programa.entity.Marca;
import com.sys.programa.entity.Modelo;
import com.sys.programa.service.IMarcaService;
import com.sys.programa.service.IModeloService;

@Controller
public class HomeController {

	@Autowired
	private IMarcaService marcaService;

	@Autowired
	private IModeloService modeloService;

	int idMarca=0;

	@GetMapping({ "/", "/index", "/home", "/inicio" })
	public String goHome(Model model) {
		List<Modelo>listaModelos=modeloService.buscarPorIdMarca(idMarca);
		
		model.addAttribute("titulo", "Combos Anidados");
		model.addAttribute("modelos", listaModelos);
		return "home";
	}

	// Obtener lista de marcas de autos
	@ModelAttribute("marcas")
	public List<Marca> getMarcas() {
		return marcaService.listarMarcas();
	}

	
	// Metodo para filtrar los modelos de autos, segun la marca seleccionada
	@GetMapping(value = "/buscarPorMarca")
	public @ResponseBody List<Modelo> todosModelosPorMarca(
			@RequestParam(value = "idMarca", required = true) int idMarca) {
		
		return modeloService.buscarPorIdMarca(idMarca);
	}

}
