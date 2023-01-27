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
@Table(name = "TB_PESSOA_JURIDICA")
public class PessoaJuridicaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long pessoaJuridicaId;
	@Column(nullable = false, unique = true, length = 1000)
	private String nome;
	@Column(nullable = true, unique = true, length = 1000)
	private String cnpj;
	@Column(nullable = true, unique = false, length = 1000)
	private String empresaId;

}
