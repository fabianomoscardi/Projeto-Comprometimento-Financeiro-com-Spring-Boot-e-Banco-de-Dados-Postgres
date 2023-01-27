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

import com.api.compromentimentofinanceiro.dtos.PessoaJuridicaDto;
import com.api.compromentimentofinanceiro.models.PessoaJuridicaModel;
import com.api.compromentimentofinanceiro.services.PessoaJuridicaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoa-juridica")
public class PessoaJuridicaController {

	@Autowired
	PessoaJuridicaService pessoaJuridicaService;

	@PostMapping("/cadastrar-pessoa-juridica")
	public ResponseEntity<PessoaJuridicaModel> cadastrarPessoaJuridica(
			@RequestBody @Valid PessoaJuridicaDto pessoaJuridicaDto) {
		PessoaJuridicaModel pessoaJuridicaModel = new PessoaJuridicaModel();
		BeanUtils.copyProperties(pessoaJuridicaDto, pessoaJuridicaModel);
		pessoaJuridicaService.cadastrarPessoaJuridica(pessoaJuridicaModel);
		return new ResponseEntity<>(pessoaJuridicaModel, HttpStatus.CREATED);
	}

	@GetMapping("/consultar-pessoa-juridica/{pessoaJuridicaId}")
	public Optional<PessoaJuridicaModel> consultarPessoaJuridica(
			@PathVariable(value = "pessoaJuridicaId") Long pessoaJuridicaId) {
		return pessoaJuridicaService.consultarPessoaJuridica(pessoaJuridicaId);
	}

	@DeleteMapping("/deletar-pessoa-juridica/{pessoaJuridicaId}")
	public ResponseEntity<Long> deletarPessoaJuridica(@PathVariable(value = "pessoaJuridicaId") Long pessoaJuridicaId) {
		pessoaJuridicaService.deletarPessoaJuridica(pessoaJuridicaId);
		return new ResponseEntity<>(pessoaJuridicaId, HttpStatus.OK);
	}
}
