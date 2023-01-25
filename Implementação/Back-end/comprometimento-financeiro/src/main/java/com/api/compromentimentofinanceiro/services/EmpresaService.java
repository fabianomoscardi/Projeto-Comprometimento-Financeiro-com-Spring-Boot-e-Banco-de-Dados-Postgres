package com.api.compromentimentofinanceiro.services;

import java.rmi.server.UID;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.compromentimentofinanceiro.models.EmpresaModel;
import com.api.compromentimentofinanceiro.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	

	@Autowired
	EmpresaRepository empresaRepository;

	public void cadastrarEmpresa(EmpresaModel empresaModel) {
		SociedadeService sociedadeService = new SociedadeService();
		sociedadeService.cadastrarSociedade(empresaModel.getSociedade());
		empresaRepository.save(empresaModel);
	}

	public Optional<EmpresaModel> consultarEmpresa(UID empresaId) {
		return empresaRepository.findById(empresaId);
	}
	
	public Double consultarComprometimentoEmpresa(UID empresaId) {
		return empresaRepository.consultarComprometimentoFinanceiro(empresaId);
	}

	public void deletarEmpresa(UID empresaId) {
		empresaRepository.deleteById(empresaId);
	}

	public String toString(EmpresaModel empresaModel) {
	
		return "O valor do comprometimento financeiro da empresa"
				+ empresaModel.getNome() 
				+ " é de" 
				+ empresaModel.getComprometimento() 
				+ ".";
	}


}
