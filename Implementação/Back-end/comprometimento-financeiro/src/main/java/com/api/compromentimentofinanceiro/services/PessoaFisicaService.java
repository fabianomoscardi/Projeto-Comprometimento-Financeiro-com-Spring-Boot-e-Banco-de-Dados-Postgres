package com.api.compromentimentofinanceiro.services;

import java.util.Optional;
import java.util.UUID;

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
	
	public Optional<PessoaFisicaModel> consultarPessoaFisica(UUID pessoaFisicaId) {
		return pessoaFisicaRepository.findById(pessoaFisicaId);
	}
	
	public void deletarPessoaFisica(Integer cpf) {
		pessoaFisicaRepository.deleteByCpf(cpf);;
	}

}
