package com.api.compromentimentofinanceiro.dtos;

import java.util.Collection;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDto {

	@NotBlank
	private String nome;
	private Collection<PessoaFisicaDto> pessoasfisicas;
	private Collection<PessoaJuridicaDto> pessoasjuridicas;

}
