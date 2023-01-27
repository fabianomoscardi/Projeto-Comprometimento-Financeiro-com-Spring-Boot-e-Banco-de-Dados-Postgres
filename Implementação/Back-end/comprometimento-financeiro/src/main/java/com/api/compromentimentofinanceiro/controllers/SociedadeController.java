package com.api.compromentimentofinanceiro.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.compromentimentofinanceiro.dtos.SociedadeDto;
import com.api.compromentimentofinanceiro.models.SociedadeModel;
import com.api.compromentimentofinanceiro.services.PessoaFisicaService;
import com.api.compromentimentofinanceiro.services.PessoaJuridicaService;
import com.api.compromentimentofinanceiro.services.SociedadeService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/sociedade")
public class SociedadeController {

	@Autowired
	SociedadeService sociedadeService;

	@PostMapping("/cadastrar-sociedade")
	public ResponseEntity<SociedadeModel> cadastrarSociedade(@RequestBody SociedadeDto sociedadeDto) {
		SociedadeModel sociedadeModel = new SociedadeModel();
		BeanUtils.copyProperties(sociedadeDto, sociedadeModel);
		sociedadeService.cadastrarSociedade(sociedadeModel);
/*		if (sociedadeModel.getPessoaFisicaId() != null) {
			PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
			pessoaFisicaService.atualizarEmpresaId(sociedadeModel.getPessoaFisicaId(), sociedadeModel.getEmpresaId());
		} else if (sociedadeModel.getPessoaJuridicaId() != null) {
			PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
			pessoaJuridicaService.atualizarEmpresaId(sociedadeModel.getPessoaJuridicaId(),
					sociedadeModel.getEmpresaId());
		} */
		return new ResponseEntity<>(sociedadeModel, HttpStatus.CREATED);
	}

}
