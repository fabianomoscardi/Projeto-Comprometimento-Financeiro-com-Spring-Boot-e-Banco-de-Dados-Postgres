package com.api.compromentimentofinanceiro.controllers;

import java.rmi.server.UID;
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

import com.api.compromentimentofinanceiro.dtos.EmpresaDto;
import com.api.compromentimentofinanceiro.models.EmpresaModel;
import com.api.compromentimentofinanceiro.services.EmpresaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/comprometimento-financeiro")
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;

	@PostMapping("/cadastrar-empresa")
	public ResponseEntity<EmpresaModel> cadastrarEmpresa(@RequestBody @Valid EmpresaDto empresaDto) {
		EmpresaModel empresaModel = new EmpresaModel();
		BeanUtils.copyProperties(empresaDto, empresaModel);
		empresaService.cadastrarEmpresa(empresaModel);
		return new ResponseEntity<>(empresaModel, HttpStatus.CREATED);
	}


	@GetMapping("/consultar-empresa/{empresaId}")
	public Optional<EmpresaModel> consultarEmpresa(@PathVariable(value="empresaId") UID empresaId) {
		return empresaService.consultarEmpresa(empresaId);
	}
	
	@GetMapping("/consultar-comprometimento/{empresaId}")
	public ResponseEntity<String> consultarComprometimentoEmpresa(@PathVariable(value="empresaId") UID empresaId) {
		EmpresaModel empresaModel = new EmpresaModel();
		empresaService.consultarComprometimentoEmpresa(empresaId);
		return new ResponseEntity<>(empresaModel.toString(), HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/deletar-empresa/{empresaId}")
	public ResponseEntity<UID> cadastrarEmpresa(@PathVariable(value="empresaId") UID empresaId) {
		empresaService.deletarEmpresa(empresaId);
		return new ResponseEntity<>(empresaId, HttpStatus.OK);
	}
	

}
