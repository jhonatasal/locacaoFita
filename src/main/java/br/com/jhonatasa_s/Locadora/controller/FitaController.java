package br.com.jhonatasa_s.Locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jhonatasa_s.Locadora.entities.Fita;
import br.com.jhonatasa_s.Locadora.services.FitaService;

@Controller
@RequestMapping("/fitas")
public class FitaController implements CrudController<Fita> {

	@Autowired
	private FitaService service;

	@Override
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<Fita> fitas = service.listar();
		model.addAttribute("fitas", fitas);
		return "/Fita/Fitas";
	}

	@Override
	@PostMapping("/salvar")
	public String salvar(Fita fita) {
		service.salvar(fita);
		return "redirect:/fitas/listar";
	}

	@Override
	@GetMapping("/excluir/{id}")
	public String excluir(Integer id) {
		service.deletar(id);
		return "redirect:/fitas/listar";
	}

	@Override
	@GetMapping("/editar/{id}")
	public String editarPag(Integer id, ModelMap model) {
		Fita fita = service.buscarPorId(id);
		model.addAttribute("fita", fita);
		return "/Fita/editarFita";
	}

	@Override
	@PostMapping("/editar")
	public String editar(Fita fita) {
		service.editar(fita);
		return "redirect:/fitas/listar";
	}

}
