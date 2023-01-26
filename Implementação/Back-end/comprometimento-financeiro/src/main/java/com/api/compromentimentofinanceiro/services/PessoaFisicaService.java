package com.api.compromentimentofinanceiro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.compromentimentofinanceiro.models.PessoaFisicaModel;
import com.api.compromentimentofinanceiro.repositories.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {

	@Autowired
	PessoaFisicaRepository pessoaFisicaRepository;

	public void cadastrarPessoaFisica(PessoaFisicaModel pessoaFisicaModel) {
		pessoaFisicaRepository.save(pessoaFisicaModel);
	}

	public Optional<PessoaFisicaModel> consultarPessoaFisica(Long pessoaFisicaId) {
		return pessoaFisicaRepository.findById(pessoaFisicaId);
	}

	public void deletarPessoaFisica(Long pessoaFisicaId) {
		pessoaFisicaRepository.deleteById(pessoaFisicaId);
		;
	}

}
