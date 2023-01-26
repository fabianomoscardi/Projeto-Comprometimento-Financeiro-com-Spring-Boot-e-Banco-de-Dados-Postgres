package com.api.compromentimentofinanceiro.models;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Table(name = "TB_EMPRESA")
public class EmpresaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String Empresaid;
	@Column(nullable = false, unique = true, length = 1000)
	private String nome;
	@Column(nullable = true, unique = true, length = 1000)
	private Double comprometimento;	
}
