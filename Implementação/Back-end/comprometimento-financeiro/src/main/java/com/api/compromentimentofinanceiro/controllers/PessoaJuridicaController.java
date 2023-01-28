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
	
	/**
	 * Cadastra uma nova pessoa juridica de acordo com os dados informados através do
	 * json postado atraves da url.
	 * [http://localhost:8080/pessoa-juridica/cadastrar-pessoa-juridica]
	 * 
	 * @param pessoaJuridicaDto Nome e cnpj da pessoa a ser cadastrada.
	 * @return Um objeto do tipo PessoaJuridicaModel contendo as informações
	 *         da pessoa cadastrada.
	 */
	@PostMapping("/cadastrar-pessoa-juridica")
	public ResponseEntity<PessoaJuridicaModel> cadastrarPessoaJuridica(
			@RequestBody @Valid PessoaJuridicaDto pessoaJuridicaDto) {
		PessoaJuridicaModel pessoaJuridicaModel = new PessoaJuridicaModel();
		BeanUtils.copyProperties(pessoaJuridicaDto, pessoaJuridicaModel);
		pessoaJuridicaService.cadastrarPessoaJuridica(pessoaJuridicaModel);
		return new ResponseEntity<>(pessoaJuridicaModel, HttpStatus.CREATED);
	}
	
	/**
	 * Consulta uma pessoa juridica cadastrada conforme o id informado na url de
	 * consulta.
	 * [http://localhost:8080/pessoa-juridica/consultar-pessoa-juridica/{pessoaJuridicaId}].
	 * 
	 * @param pessoaJuridicaId Id da pessoa juridica a ser consultada.
	 * @return Um objeto do tipo PessoaJuridicaModel contendo as informações
	 *         da pessoa consultada.
	 */
	@GetMapping("/consultar-pessoa-juridica/{pessoaJuridicaId}")
	public Optional<PessoaJuridicaModel> consultarPessoaJuridica(
			@PathVariable(value = "pessoaJuridicaId") Long pessoaJuridicaId) {
		return pessoaJuridicaService.consultarPessoaJuridica(pessoaJuridicaId);
	}
	
	/**
	 * Deleta uma pessoa juridica cadastrada informada na url.
	 * [http://localhost:8080/pessoa-juridica/deletar-pessoa-juridica/{pessoaJuridicaId}]
	 * 
	 * @param pessoaJuridicaId Id da pessoa juridica a ser deletada.
	 * @return Um Objeto do tipo Long contendo o Id da pessoa deletada.
	 */
	@DeleteMapping("/deletar-pessoa-juridica/{pessoaJuridicaId}")
	public ResponseEntity<Long> deletarPessoaJuridica(@PathVariable(value = "pessoaJuridicaId") Long pessoaJuridicaId) {
		pessoaJuridicaService.deletarPessoaJuridica(pessoaJuridicaId);
		return new ResponseEntity<>(pessoaJuridicaId, HttpStatus.OK);
	}
}
