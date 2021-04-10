package br.com.jhonatasa_s.Locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jhonatasa_s.Locadora.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
