package br.com.jhonatasa_s.Locadora.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente extends Pessoa{
	private static final long serialVersionUID = 1L;
}
