package br.com.jhonatasa_s.Locadora.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatasa_s.Locadora.controller.dto.LocacaoDTO;
import br.com.jhonatasa_s.Locadora.entities.Locacao;
import br.com.jhonatasa_s.Locadora.repositories.ClienteRepository;
import br.com.jhonatasa_s.Locadora.repositories.ColaboradorRepository;
import br.com.jhonatasa_s.Locadora.repositories.FitaRepository;
import br.com.jhonatasa_s.Locadora.repositories.LocacaoRepository;

@Service
public class LocacaoService {
	@Autowired
	private LocacaoRepository locacaoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@Autowired
	private FitaRepository fitaRepository;

	public List<LocacaoDTO> listar() {
		List<Locacao> locacoes = locacaoRepository.findAll();
		List<LocacaoDTO> locacoesDto = new ArrayList<>();
		for (Locacao loc : locacoes) {
			LocacaoDTO locacaoDto = new LocacaoDTO();
			locacaoDto.setId(loc.getId());
			locacaoDto.setFita(fitaRepository.findById(loc.getId_fita()).get().getNome() + " R$ : "
					+ fitaRepository.findById(loc.getId_fita()).get().getPreco());
			locacaoDto.setColaborador(colaboradorRepository.findById(loc.getId_colaborador()).get().getNome());
			locacaoDto.setCliente(clienteRepository.findById(loc.getId_cliente()).get().getNome());
			locacoesDto.add(locacaoDto);
		}
		return locacoesDto;
	}

	public void deletar(Integer id) {
		locacaoRepository.deleteById(id);
	}

	public void salvar(Locacao locacao) {
		locacaoRepository.save(locacao);
	}
}
