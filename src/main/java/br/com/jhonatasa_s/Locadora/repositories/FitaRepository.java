package br.com.jhonatasa_s.Locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jhonatasa_s.Locadora.entities.Fita;
@Repository
public interface FitaRepository extends JpaRepository<Fita, Integer>{

}
