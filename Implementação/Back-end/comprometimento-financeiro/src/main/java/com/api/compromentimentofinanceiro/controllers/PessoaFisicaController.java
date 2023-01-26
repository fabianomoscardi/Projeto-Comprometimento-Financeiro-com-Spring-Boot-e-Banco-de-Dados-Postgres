package com.api.compromentimentofinanceiro.controllers;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.compromentimentofinanceiro.dtos.PessoaFisicaDto;
import com.api.compromentimentofinanceiro.models.PessoaFisicaModel;
import com.api.compromentimentofinanceiro.services.PessoaFisicaService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoa-fisica")
public class PessoaFisicaController {

	@Autowired
	PessoaFisicaService pessoaFisicaService;

	@PostMapping("/cadastrar-pessoa-fisica")
	public ResponseEntity<PessoaFisicaModel> cadastrarPessoaFisica(@RequestBody PessoaFisicaDto pessoaFisicaDto) {
		PessoaFisicaModel pessoaFisicaModel = new PessoaFisicaModel();
		BeanUtils.copyProperties(pessoaFisicaDto, pessoaFisicaModel);
		pessoaFisicaService.cadastrarPessoaFisica(pessoaFisicaModel);
		return new ResponseEntity<>(pessoaFisicaModel, HttpStatus.CREATED);
	}

	@GetMapping("/consultar-pessoa-fisica/{pessoaFisicaId}")
	public Optional<PessoaFisicaModel> consultarPessoaFisica(
			@PathVariable(value = "pessoaFisicaId") Long pessoaFisicaId) {
		return pessoaFisicaService.consultarPessoaFisica(pessoaFisicaId);
	}

	@DeleteMapping("/deletar-pessoa-fisica/{pessoaFisicaId}")
	public ResponseEntity<Long> deletarPessoaFisica(@PathVariable(value = "pessoaFisicaId") Long pessoaFisicaId) {
		pessoaFisicaService.deletarPessoaFisica(pessoaFisicaId);
		return new ResponseEntity<>(pessoaFisicaId, HttpStatus.OK);
	}

}
