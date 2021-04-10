package br.com.jhonatasa_s.Locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jhonatasa_s.Locadora.entities.Colaborador;
import br.com.jhonatasa_s.Locadora.services.ColaboradorService;

@Controller
@RequestMapping("/colaborador")
public class ColaboradorController implements CrudController<Colaborador>{

	@Autowired
	private ColaboradorService service;

	@Override
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<Colaborador> colaboradores = service.listar();
		model.addAttribute("colaboradores", colaboradores);
		return "/Colaborador/Colaborador";
	}

	@Override
	@PostMapping("/salvar")
	public String salvar(Colaborador colaborador) {
		service.salvar(colaborador);
		return "redirect:/colaborador/listar";
	}

	@Override
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id) {
		service.deletar(id);
		return "redirect:/colaborador/listar";
	}
	
	@Override
	@GetMapping("/editar/{id}")
	public String editarPag(@PathVariable("id") Integer id, ModelMap model) {
		Colaborador colaborador = service.buscarPorId(id);
		model.addAttribute("colaborador", colaborador);
		return "/Colaborador/editarColaborador";
	}

	@Override
	@PostMapping("/editar")
	public String editar(Colaborador colaborador) {
		service.editar(colaborador);
		return "redirect:/colaborador/listar";
	}

}
