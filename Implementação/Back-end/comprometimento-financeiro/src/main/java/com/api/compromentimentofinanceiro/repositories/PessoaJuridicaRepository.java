package com.api.compromentimentofinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.compromentimentofinanceiro.models.PessoaJuridicaModel;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridicaModel, Long> {

	void deleteByCnpj(Integer cnpj);

}
