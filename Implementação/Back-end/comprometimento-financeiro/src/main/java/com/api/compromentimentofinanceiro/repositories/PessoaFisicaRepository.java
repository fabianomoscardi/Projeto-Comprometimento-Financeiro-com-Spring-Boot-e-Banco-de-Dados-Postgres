package com.api.compromentimentofinanceiro.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.compromentimentofinanceiro.models.PessoaFisicaModel;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisicaModel, UUID>{

}
