package com.api.compromentimentofinanceiro.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.compromentimentofinanceiro.models.SociedadeModel;
import com.api.compromentimentofinanceiro.repositories.SociedadeRepository;

@Service
public class SociedadeService {

	@Autowired
	SociedadeRepository SociedadeRepository;

	public void cadastrarSociedade(SociedadeModel sociedadeModel) {
		SociedadeRepository.save(sociedadeModel);
	}

	public Optional<SociedadeModel> consultarSociedade(UUID sociedadeId) {
		return SociedadeRepository.findById(sociedadeId);
	}

	public void deletarSociedade(UUID sociedadeId) {
		SociedadeRepository.deleteById(sociedadeId);
	}

}
