package com.api.compromentimentofinanceiro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PROPRIEDADE")
public class PropriedadeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long propriedadeId;
	@Column(nullable = false, unique = false, length = 1000)
	private String nome;
	@Column(nullable = true, unique = false, length = 1000)
	private Long pessoaFisicaId;
	@Column(nullable = true, unique = false, length = 1000)
	private Long pessoaJuridicaId;
	@Column(nullable = false, unique = false, length = 1000)
	private Long empresaId;
	@Column(nullable = false, unique = false, length = 1000)
	private Double valor;
}
