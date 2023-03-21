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

import com.api.compromentimentofinanceiro.dtos.EmpresaDto;
import com.api.compromentimentofinanceiro.models.EmpresaModel;
import com.api.compromentimentofinanceiro.services.EmpresaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;

	/**
	 * Cadastra uma nova empresa de acordo com os dados informados através do json
	 * postado atraves da url. [http://localhost:8080/empresa/cadastrar-empresa]
	 * 
	 * @param empresaDto Nome da empresa a ser cadastrada.
	 * @return Um objeto do tipo EmpresaModel contendo as informações da
	 *         empresa cadastrada.
	 */
	@PostMapping("/cadastrar-empresa")
	public ResponseEntity<EmpresaModel> cadastrarEmpresa(@RequestBody @Valid EmpresaDto empresaDto) {
		EmpresaModel empresaModel = new EmpresaModel();
		BeanUtils.copyProperties(empresaDto, empresaModel);
		empresaService.cadastrarEmpresa(empresaModel);
		return new ResponseEntity<>(empresaModel, HttpStatus.CREATED);
	}

	/**
	 * Consulta uma empresa cadastrada conforme o id informado na url de consulta.
	 * [http://localhost:8080/empresa/consultar-comprometimento/{empresaId}].
	 * 
	 * @param empresaId Id da empresa a ser consultada.
	 * @return Um objeto do tipo EmpresaModel contendo as informações da
	 *         empresa consultada.
	 */
	@GetMapping("/consultar-empresa/{empresaId}")
	public ResponseEntity<Object> consultarEmpresa(@PathVariable(value = "empresaId") Long empresaId) {
		Optional<EmpresaModel> empresaModelOptional = empresaService.consultarEmpresa(empresaId);
		if (!empresaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(empresaModelOptional.get());
	}

	/**
	 * Consulta a soma total dos valores de cada imóvel no nome de cada pessoa
	 * contituida pela empresa informada na url.
	 * [http://localhost:8080/empresa/consultar-comprometimento/{empresaId}]
	 * 
	 * @param empresaId Id da empresa a ser consultada.
	 * @return Uma String contendo uma váriavel do tipo Double com a soma total dos
	 *         valores de cada imóvel no nome de cada pessoa que constitue a empresa
	 *         informada.
	 */
	@GetMapping("/consultar-comprometimento/{empresaId}")
	public ResponseEntity<String> consultarComprometimentoEmpresa(@PathVariable(value = "empresaId") Long empresaId) {
		Long empresaSociaId = empresaId;
		Optional<EmpresaModel> empresaModelOptional = empresaService.consultarEmpresa(empresaId);
		Double comprometimento = empresaService.consultarComprometimentoEmpresa(empresaId, empresaSociaId);
		return new ResponseEntity<>("O comprometimento financeiro atual da empresa "
				+ empresaModelOptional.get().getNome() + " é de R$" + comprometimento + ".", HttpStatus.CREATED);
	}

	/**
	 * Deleta uma empresa cadastrada informada na url.
	 * [http://localhost:8080/empresa/deletar-empresa/{empresaId}]
	 * 
	 * @param empresaId Id da empresa a ser deletada.
	 * @return Um Objeto do tipo Long contendo o Id da empresa deletada.
	 */
	@DeleteMapping("/deletar-empresa/{empresaId}")
	public ResponseEntity<Long> deletarEmpresa(@PathVariable(value = "empresaId") Long empresaId) {
		empresaService.deletarEmpresa(empresaId);
		return new ResponseEntity<>(empresaId, HttpStatus.OK);
	}

}
