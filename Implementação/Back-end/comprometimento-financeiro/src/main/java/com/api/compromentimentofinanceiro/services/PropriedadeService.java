package com.api.compromentimentofinanceiro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.compromentimentofinanceiro.models.PropriedadeModel;
import com.api.compromentimentofinanceiro.repositories.PropriedadeRepository;

import jakarta.transaction.Transactional;

@Service
public class PropriedadeService {

	@Autowired
	PropriedadeRepository propriedadeRepository;

	@Transactional
	public void cadastrarPropriedade(PropriedadeModel propriedadeModel) {
		propriedadeRepository.save(propriedadeModel);
	}

	public Optional<PropriedadeModel> consultarPropriedade(Long propriedadeId) {
		return propriedadeRepository.findById(propriedadeId);
	}

	@Transactional
	public void deletarPropriedade(Long propriedadeId) {
		propriedadeRepository.deleteById(propriedadeId);
		;
	}

}
