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
public class SociedadeDto {
	
	@NotBlank
	private Long empresaId;
	private Long pessoaFisicaId;
	private Long pessoaJuridicaId;
	private Long empresaSociaId;
}
