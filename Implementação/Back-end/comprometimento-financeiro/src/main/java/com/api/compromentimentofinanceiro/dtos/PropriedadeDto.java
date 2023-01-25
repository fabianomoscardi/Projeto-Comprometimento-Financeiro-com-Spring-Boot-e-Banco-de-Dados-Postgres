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
	@NotBlank
	private Double valor;
	

}
