package com.api.compromentimentofinanceiro.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropriedadeDto {

	@NotBlank
	private String nome;
	private Long pessoaFisicaId;
	private Long pessoaJuridicaId;
	@NotBlank
	private Long empresaId;
	@NotBlank
	private Double valor;

}
