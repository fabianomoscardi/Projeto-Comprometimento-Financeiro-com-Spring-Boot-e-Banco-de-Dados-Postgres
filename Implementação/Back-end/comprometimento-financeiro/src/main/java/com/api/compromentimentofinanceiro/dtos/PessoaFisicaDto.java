package com.api.compromentimentofinanceiro.dtos;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PessoaFisicaDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	@CPF
	private int cpf;

}
