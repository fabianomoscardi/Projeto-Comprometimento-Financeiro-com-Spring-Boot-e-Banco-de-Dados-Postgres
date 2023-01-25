package com.api.compromentimentofinanceiro.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TB_SOCIEDADE")
public class SociedadeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID sociedadeId;
	@Column(nullable = false, unique = true, length = 10)
	private int socio;
}
