package com.api.compromentimentofinanceiro.models;

import java.io.Serializable;
import java.rmi.server.UID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TB_EMPRESA")
public class EmpresaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UID Empresaid;
	@Column(nullable = false, unique = true, length = 10)
	private String nome;
	@Column(nullable = false, unique = true, length = 10)
	private SociedadeModel sociedade;
	@Column(nullable = false, unique = true, length = 10)
	private Double comprometimento;
	
	
}
