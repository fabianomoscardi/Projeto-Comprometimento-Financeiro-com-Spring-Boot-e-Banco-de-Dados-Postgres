package com.api.compromentimentofinanceiro.dtos;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaJuridicaDto {

	@NotBlank
	private String nome;
	@NotBlank
	@CNPJ
	private String cnpj;

}
