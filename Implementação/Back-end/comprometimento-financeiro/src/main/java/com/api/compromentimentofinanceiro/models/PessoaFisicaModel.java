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
@Table(name = "TB_PESSOA_FISICA")
public class PessoaFisicaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long pessoaFisicaId;
	@Column(nullable = false, unique = true, length = 1000)
	private String nome;
	@Column(nullable = true, unique = true, length = 1000)
	private int cpf;
	@Column(nullable = true, unique = false, length = 1000)
	private Long empresaId;

}
