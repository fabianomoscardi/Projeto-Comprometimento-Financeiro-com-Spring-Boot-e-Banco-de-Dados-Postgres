package com.api.compromentimentofinanceiro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.compromentimentofinanceiro.models.EmpresaModel;
import com.api.compromentimentofinanceiro.repositories.EmpresaRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;

	public void cadastrarEmpresa(EmpresaModel empresaModel) {
		empresaRepository.save(empresaModel);
	}

	public Optional<EmpresaModel> consultarEmpresa(Long empresaId) {
		return empresaRepository.findById(empresaId);
	}

	public Double consultarComprometimentoEmpresa(Long empresaId, Long empresaSociaId) {
		return empresaRepository.consultarComprometimentoEmpresa(empresaId, empresaSociaId);
	}

	@Transactional
	public void deletarEmpresa(Long empresaId) {
		empresaRepository.deleteById(empresaId);
	}

}
