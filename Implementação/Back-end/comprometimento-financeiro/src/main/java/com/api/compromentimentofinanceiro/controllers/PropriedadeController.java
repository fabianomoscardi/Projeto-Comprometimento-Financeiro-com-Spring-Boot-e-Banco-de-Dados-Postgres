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

	/**
	 * Cadastra uma nova propriedade de acordo com os dados informados através do
	 * json postado atraves da url.
	 * [http://localhost:8080/propriedade/cadastrar-propriedade]
	 * 
	 * @param propriedadeDto Nome da propriedade, Id da pessoa juridica ou fisica
	 *                       responsável pela propriedade e Id referente a empresa
	 *                       que essa pessoa pertence.
	 * @return Um objeto do tipo PropriedadeModel contendo as informações da
	 *         propriedade cadastrada.
	 */
	@PostMapping("/cadastrar-propiedade")
	public ResponseEntity<PropriedadeModel> cadastrarPropriedade(@RequestBody PropriedadeDto propriedadeDto) {
		PropriedadeModel propriedadeModel = new PropriedadeModel();
		BeanUtils.copyProperties(propriedadeDto, propriedadeModel);
		propriedadeService.cadastrarPropriedade(propriedadeModel);
		return new ResponseEntity<>(propriedadeModel, HttpStatus.CREATED);
	}
	
	/**
	 * Consulta uma propriedade cadastrada conforme o id informado na url de
	 * consulta.
	 * [http://localhost:8080/propriedade/consultar-propriedade/{propriedadeId}].
	 * 
	 * @param propriedadeId Id da propriedade a ser consultada.
	 * @return Um objeto do tipo PropriedadeModel contendo as informações
	 *         da propriedade consultada.
	 */
	@GetMapping("/consultar-propriedade/{propriedadeId}")
	public Optional<PropriedadeModel> consultarPropriedade(@PathVariable(value = "propriedadeId") Long propriedadeId) {
		return propriedadeService.consultarPropriedade(propriedadeId);
	}

	/**
	 * Deleta uma pessoa juridica cadastrada informada na url.
	 * [http://localhost:8080/propriedade/deletar-propriedade/{propriedadeId}]
	 * 
	 * @param propriedadeId Id da propriedade a ser deletada.
	 * @return Um Objeto do tipo Long contendo o Id da propriedade deletada.
	 */
	@DeleteMapping("/deletar-propriedade/{propriedadeId}")
	public ResponseEntity<Long> deletarPropriedade(@PathVariable(value = "propriedadeId") Long propriedadeId) {
		propriedadeService.deletarPropriedade(propriedadeId);
		return new ResponseEntity<>(propriedadeId, HttpStatus.OK);
	}

}
