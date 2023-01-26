package com.api.compromentimentofinanceiro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.compromentimentofinanceiro.models.PessoaJuridicaModel;
import com.api.compromentimentofinanceiro.repositories.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {

	@Autowired
	PessoaJuridicaRepository pessoaJuridicaRepository;

	public void cadastrarPessoaJuridica(PessoaJuridicaModel pessoaJuridicaModel) {
		pessoaJuridicaRepository.save(pessoaJuridicaModel);
	}

	public Optional<PessoaJuridicaModel> consultarPessoaJuridica(Long pessoaJuridicaId) {
		return pessoaJuridicaRepository.findById(pessoaJuridicaId);
	}

	public void deletarPessoaJuridica(Long pessoaJuridicaId) {
		pessoaJuridicaRepository.deleteById(pessoaJuridicaId);
	}

}
