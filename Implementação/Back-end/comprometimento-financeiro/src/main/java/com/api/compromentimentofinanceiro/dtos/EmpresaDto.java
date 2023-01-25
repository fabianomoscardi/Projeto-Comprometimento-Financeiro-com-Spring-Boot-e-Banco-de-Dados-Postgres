package com.api.compromentimentofinanceiro.dtos;

import java.util.Collection;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmpresaDto {

	@NotBlank
	private String nome;
	private Collection<PessoaFisicaDto> pessoasfisicas;
	private Collection<PessoaJuridicaDto> pessoasjuridicas;

}
