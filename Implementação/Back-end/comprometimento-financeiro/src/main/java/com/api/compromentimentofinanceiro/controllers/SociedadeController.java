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
import com.api.compromentimentofinanceiro.services.SociedadeService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/sociedade")
public class SociedadeController {

	@Autowired
	SociedadeService sociedadeService;

	@PostMapping("/cadastrar-sociedade")
	public ResponseEntity<SociedadeModel> cadastrarSociedade(@RequestBody @Valid SociedadeDto sociedadeDto) {
		SociedadeModel sociedadeModel = new SociedadeModel();
		BeanUtils.copyProperties(sociedadeDto, sociedadeModel);
		sociedadeService.cadastrarSociedade(sociedadeModel);
		return new ResponseEntity<>(sociedadeModel, HttpStatus.CREATED);
	}

}
