package br.com.jhonatasa_s.Locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jhonatasa_s.Locadora.entities.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Integer>{

}
