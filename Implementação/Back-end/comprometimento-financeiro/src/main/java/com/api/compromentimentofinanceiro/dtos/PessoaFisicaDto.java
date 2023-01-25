package com.api.compromentimentofinanceiro.dtos;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisicaDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	@CPF
	private int cpf;

}
