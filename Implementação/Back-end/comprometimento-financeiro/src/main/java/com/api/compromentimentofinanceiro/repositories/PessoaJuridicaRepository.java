package com.api.compromentimentofinanceiro.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.compromentimentofinanceiro.models.PessoaJuridicaModel;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridicaModel, UUID> {

}
