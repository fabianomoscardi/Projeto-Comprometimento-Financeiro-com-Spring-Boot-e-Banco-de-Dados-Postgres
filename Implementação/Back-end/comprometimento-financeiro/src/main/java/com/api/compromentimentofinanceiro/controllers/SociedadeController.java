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

import com.api.compromentimentofinanceiro.dtos.SociedadeDto;
import com.api.compromentimentofinanceiro.models.SociedadeModel;
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

	/**
	 * Cadastra uma nova sociedade de acordo com os dados informados através do json
	 * postado atraves da url. [http://localhost:8080/sociedade/cadastrar-sociedade]
	 * 
	 * @param sociedadeDto Nome da sociedade, Id da pessoa juridica ou fisica ou da
	 *                     empresa a ser cadastrada e Id referente referente a qual
	 *                     empresa será estabelecida a sociedade. 
	 * @return Um objeto do tipo SociedadeModel contendo as informações da sociedade
	 *         cadastrada.
	 */
	@PostMapping("/cadastrar-sociedade")
	public ResponseEntity<SociedadeModel> cadastrarSociedade(@RequestBody SociedadeDto sociedadeDto) {
		SociedadeModel sociedadeModel = new SociedadeModel();
		BeanUtils.copyProperties(sociedadeDto, sociedadeModel);
		sociedadeService.cadastrarSociedade(sociedadeModel);
		return new ResponseEntity<>(sociedadeModel, HttpStatus.CREATED);
	}
	
	/**
	 * Consulta uma sociedade cadastrada conforme o id informado na url de
	 * consulta.
	 * [http://localhost:8080/sociedade/consultar-sociedade/{sociedadeId}].
	 * 
	 * @param sociedadeId Id da sociedade a ser consultada.
	 * @return Um objeto do tipo SociedadeModel contendo as informações
	 *         da sociedade consultada.
	 */
	@GetMapping("/consultar-sociedade/{sociedadeId}")
	public Optional<SociedadeModel> consultarSociedade(@PathVariable(value = "sociedadeId") Long sociedadeId) {
		return sociedadeService.consultarSociedade(sociedadeId);
	}

	/**
	 * Deleta uma pessoa juridica cadastrada informada na url.
	 * [http://localhost:8080/sociedade/deletar-sociedade/{sociedadeId}]
	 * 
	 * @param sociedadeId Id da sociedade a ser deletada.
	 * @return Um Objeto do tipo Long contendo o Id da sociedade deletada.
	 */
	@DeleteMapping("/deletar-sociedade/{sociedadeId}")
	public ResponseEntity<Long> deletarSociedade(@PathVariable(value = "sociedadeId") Long sociedadeId) {
		sociedadeService.deletarSociedade(sociedadeId);
		return new ResponseEntity<>(sociedadeId, HttpStatus.OK);
	}

}
