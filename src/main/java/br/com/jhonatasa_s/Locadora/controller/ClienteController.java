package br.com.jhonatasa_s.Locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jhonatasa_s.Locadora.entities.Cliente;
import br.com.jhonatasa_s.Locadora.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController implements CrudController<Cliente> {
	@Autowired
	private ClienteService clienteService;

	@Override
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<Cliente> clientes = clienteService.listar();
		model.addAttribute("clientes", clientes);
		return "/Clientes/Clientes";
	}

	@Override
	@PostMapping("/salvar")
	public String salvar(Cliente cliente) {
		clienteService.salvar(cliente);
		return "redirect:/clientes/listar";
	}

	@Override
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id) {
		clienteService.deletar(id);
		return "redirect:/clientes/listar";
	}

	@Override
	@GetMapping("/editar/{id}")
	public String editarPag(@PathVariable("id") Integer id, ModelMap model) {
		Cliente cliente = clienteService.buscarPorId(id);
		model.addAttribute("cliente", cliente);
		return "/Clientes/editarCliente";
	}

	@PostMapping("/editar")
	public String editar(Cliente cliente) {
		clienteService.editar(cliente);
		return "redirect:/clientes/listar";
	}

}
