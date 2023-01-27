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

import com.api.compromentimentofinanceiro.dtos.PropriedadeDto;
import com.api.compromentimentofinanceiro.models.PropriedadeModel;
import com.api.compromentimentofinanceiro.services.PropriedadeService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/propriedade")
public class PropriedadeController {

	@Autowired
	PropriedadeService propriedadeService;

	@PostMapping("/cadastrar-propiedade")
	public ResponseEntity<PropriedadeModel> cadastrarPropriedade(@RequestBody PropriedadeDto propriedadeDto) {
		PropriedadeModel propriedadeModel = new PropriedadeModel();
		BeanUtils.copyProperties(propriedadeDto, propriedadeModel);
		propriedadeService.cadastrarPropriedade(propriedadeModel);
		return new ResponseEntity<>(propriedadeModel, HttpStatus.CREATED);
	}

	@GetMapping("/consultar-propriedade/{propriedadeId}")
	public Optional<PropriedadeModel> consultarPropriedade(@PathVariable(value = "propriedadeId") Long propriedadeId) {
		return propriedadeService.consultarPropriedade(propriedadeId);
	}

	@DeleteMapping("/deletar-propriedade/{propriedadeId}")
	public ResponseEntity<Long> deletarPropriedade(@PathVariable(value = "propriedadeId") Long propriedadeId) {
		propriedadeService.deletarPropriedade(propriedadeId);
		return new ResponseEntity<>(propriedadeId, HttpStatus.OK);
	}

}
