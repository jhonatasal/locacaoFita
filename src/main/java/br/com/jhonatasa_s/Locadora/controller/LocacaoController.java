package br.com.jhonatasa_s.Locadora.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jhonatasa_s.Locadora.controller.dto.LocacaoDTO;
import br.com.jhonatasa_s.Locadora.entities.Cliente;
import br.com.jhonatasa_s.Locadora.entities.Colaborador;
import br.com.jhonatasa_s.Locadora.entities.Fita;
import br.com.jhonatasa_s.Locadora.entities.Locacao;
import br.com.jhonatasa_s.Locadora.services.ClienteService;
import br.com.jhonatasa_s.Locadora.services.ColaboradorService;
import br.com.jhonatasa_s.Locadora.services.FitaService;
import br.com.jhonatasa_s.Locadora.services.LocacaoService;

@Controller
@RequestMapping("/locacao")
public class LocacaoController  {

	@Autowired
	private LocacaoService locacaoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ColaboradorService colaboradorService;

	@Autowired
	private FitaService fitaService;

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<LocacaoDTO> locacoes = locacaoService.listar();
		List<Fita> fitas = new ArrayList<>();
		fitaService.listar().stream().forEach(x -> {
			x.setNome(x.getNome()+ " R$ : "+x.getPreco());
			fitas.add(x);
		});
		List<Cliente> clientes = clienteService.listar();
		List<Colaborador> colaboradores = colaboradorService.listar();
		Locacao locacao = new Locacao();
		model.addAttribute("locacoes", locacoes);
		model.addAttribute("fitas", fitas);
		model.addAttribute("clientes", clientes);
		model.addAttribute("colaboradores", colaboradores);
		model.addAttribute("locacao", locacao);

		return "/Locacao/Locacao";
	}

	@PostMapping("/salvar")
	public String salvar(Locacao locacao) {
		locacaoService.salvar(locacao);
		return "redirect:/locacao/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id) {
		locacaoService.deletar(id);
		return "redirect:/locacao/listar";
	}

}
