package br.com.jhonatasa_s.Locadora.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatasa_s.Locadora.entities.Fita;
import br.com.jhonatasa_s.Locadora.repositories.FitaRepository;

@Service
public class FitaService {

	@Autowired
	private FitaRepository repository;

	public List<Fita> listar() {
		return repository.findAll();
	}

	public void salvar(Fita fita) {
		repository.save(fita);
	}

	public void deletar(Integer id) {
		Fita fita = repository.findById(id).get();
		repository.delete(fita);
	}

	public Fita buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	public Fita editar(Fita fita) {
		Fita fitaOld = repository.findById(fita.getId()).get();
		fitaOld.setNome(fita.getNome());
		fitaOld.setPreco(fita.getPreco());
		return null;
	}

}
