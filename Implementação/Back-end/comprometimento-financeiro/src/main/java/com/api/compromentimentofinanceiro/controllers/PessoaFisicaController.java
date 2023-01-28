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

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoa-fisica")
public class PessoaFisicaController {

	@Autowired
	PessoaFisicaService pessoaFisicaService;

	/**
	 * Cadastra uma nova pessoa fisica de acordo com os dados informados através do
	 * json postado atraves da url.
	 * [http://localhost:8080/pessoa-fisica/cadastrar-pessoa-fisica]
	 * 
	 * @param pessoaFisicaDto Nome e cpf da pessoa a ser cadastrada.
	 * @return Um objeto do tipo PessoaFisicaModel contendo as informações
	 *         da pessoa cadastrada.
	 */
	@PostMapping("/cadastrar-pessoa-fisica")
	public ResponseEntity<PessoaFisicaModel> cadastrarPessoaFisica(
			@RequestBody @Valid PessoaFisicaDto pessoaFisicaDto) {
		PessoaFisicaModel pessoaFisicaModel = new PessoaFisicaModel();
		BeanUtils.copyProperties(pessoaFisicaDto, pessoaFisicaModel);
		pessoaFisicaService.cadastrarPessoaFisica(pessoaFisicaModel);
		return new ResponseEntity<>(pessoaFisicaModel, HttpStatus.CREATED);
	}

	/**
	 * Consulta uma pessoa fisica cadastrada conforme o id informado na url de
	 * consulta.
	 * [http://localhost:8080/pessoa-fisica/consultar-pessoa-fisica/{pessoaFisicaId}].
	 * 
	 * @param pessoaFisicaId Id da pessoa fisica a ser consultada.
	 * @return Um objeto do tipo PessoaFisicaModel contendo as informações
	 *         da pessoa consultada.
	 */
	@GetMapping("/consultar-pessoa-fisica/{pessoaFisicaId}")
	public Optional<PessoaFisicaModel> consultarPessoaFisica(
			@PathVariable(value = "pessoaFisicaId") Long pessoaFisicaId) {
		return pessoaFisicaService.consultarPessoaFisica(pessoaFisicaId);
	}

	/**
	 * Deleta uma pessoa fisica cadastrada informada na url.
	 * [http://localhost:8080/pessoa-fisica/deletar-pessoa-fisica/{pessoaFisicaId}]
	 * 
	 * @param pessoaFisicaId Id da pessoa fisica a ser deletada.
	 * @return Um Objeto do tipo Long contendo o Id da pessoa deletada.
	 */
	@DeleteMapping("/deletar-pessoa-fisica/{pessoaFisicaId}")
	public ResponseEntity<Long> deletarPessoaFisica(@PathVariable(value = "pessoaFisicaId") Long pessoaFisicaId) {
		pessoaFisicaService.deletarPessoaFisica(pessoaFisicaId);
		return new ResponseEntity<>(pessoaFisicaId, HttpStatus.OK);
	}

}
