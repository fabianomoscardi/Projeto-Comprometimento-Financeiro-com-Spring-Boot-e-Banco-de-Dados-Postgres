package com.api.compromentimentofinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.compromentimentofinanceiro.models.PessoaFisicaModel;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisicaModel, Long> {

}
