package com.api.compromentimentofinanceiro.dtos;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PessoaJuridicaDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	@CNPJ
	private int cnpj;

}
