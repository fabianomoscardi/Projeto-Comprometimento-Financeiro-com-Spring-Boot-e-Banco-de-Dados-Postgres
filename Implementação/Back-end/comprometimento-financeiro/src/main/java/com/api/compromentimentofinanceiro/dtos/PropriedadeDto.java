package com.api.compromentimentofinanceiro.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PropriedadeDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	private Double valor;
	

}
