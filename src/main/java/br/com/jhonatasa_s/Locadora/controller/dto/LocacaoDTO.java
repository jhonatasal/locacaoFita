package br.com.jhonatasa_s.Locadora.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocacaoDTO {
	private Integer id;
	private String cliente;
	private String colaborador;
	private String fita;
}
