package com.api.compromentimentofinanceiro.repositories;

import java.rmi.server.UID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.compromentimentofinanceiro.models.EmpresaModel;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, UID>{

	List<EmpresaModel> findByCnpj(Integer cnpj);
	
	@Query(
			value = "SELECT COUNT(p.VALOR) AS COMPROMETIMENTO_FINANCEIRO FROM TB_PROPIEDADE pe"
					+ " INNER JOIN TB_EMPRESA ep ON pe.EMPRESAID = ep.EMPRESAID"
					+ " INNER JOIN TB_PESSOA_FISICA pf ON ep.PESSOAFISICAID = pf.PESSOAFISICAID"
					+ " INNER JOIN TB_PESSOA_JURIDICA pj ON ep.PESSOAJURIDICAID = pj.PESSOAJURIDICAID"
					+ "WHERE ep.EMPRESAID = ?1"

			)
	Double consultarComprometimentoFinanceiro(UID empresaid);
	
}
