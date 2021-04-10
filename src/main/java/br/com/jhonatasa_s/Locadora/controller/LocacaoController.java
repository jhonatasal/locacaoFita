package br.com.jhonatasa_s.Locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import br.com.jhonatasa_s.Locadora.entities.Locacao;
import br.com.jhonatasa_s.Locadora.services.LocacaoService;

@Controller
public class LocacaoController implements CrudController<Locacao> {

	@Autowired
	private LocacaoService locacaoService;
	
	@Override
	public String listar(ModelMap model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar(Locacao locacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editarPag(Integer id, ModelMap model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editar(Locacao locacao) {
		// TODO Auto-generated method stub
		return null;
	}

}
