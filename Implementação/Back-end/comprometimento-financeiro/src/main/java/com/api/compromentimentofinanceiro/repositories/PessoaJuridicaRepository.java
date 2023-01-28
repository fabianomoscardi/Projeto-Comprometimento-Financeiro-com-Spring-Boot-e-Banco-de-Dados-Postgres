package com.api.compromentimentofinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.compromentimentofinanceiro.models.PessoaJuridicaModel;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridicaModel, Long> {

	void deleteByCnpj(Integer cnpj);
	
	@Modifying
	@Query("UPDATE TB_PESSOA_JURIDICA SET EMPRESA_ID = ?2 WHERE PESSOA_FISICA_ID = ?1")
	void atualizarEmpresaId(Long pessoaJuridicaId, Long empresaId);

}
