package br.com.jhonatasa_s.Locadora.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.jhonatasa_s.Locadora.entities.Pessoa;

@Service
@Repository
public abstract class ServiceEntitiesPessoa<T extends Pessoa> {

	@Autowired
	private JpaRepository<T, Integer> repository;

	public List<T> listar() {
		return repository.findAll();
	}

	public void salvar(T pessoa) {
		pessoa.setCpf(pessoa.getCpf().replace(".", "").replace("-", ""));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		pessoa.setData_cadastro(sdf.format(new Date(System.currentTimeMillis())));
		repository.save(pessoa);
	}

	public void deletar(Integer id) {
		T pessoa = repository.findById(id).get();
		repository.delete(pessoa);
	}

	public T buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	public void editar(T pessoa) {
		pessoa.setCpf(pessoa.getCpf().replace(".", "").replace("-", ""));
		T pessoaOld = repository.findById(pessoa.getId()).get();
		pessoaOld.setNome(pessoa.getNome());
		pessoaOld.setCpf(pessoa.getCpf());
		repository.save(pessoaOld);
	}
}
