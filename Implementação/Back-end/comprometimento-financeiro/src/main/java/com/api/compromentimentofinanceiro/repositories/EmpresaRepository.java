package com.api.compromentimentofinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.compromentimentofinanceiro.models.EmpresaModel;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long> {

	@Query(value = "SELECT SUM(RESULT.COMPROMETIMENTO) FROM (\r\n"
			+ "SELECT VALOR  AS COMPROMETIMENTO FROM TB_PROPRIEDADE 	\r\n"
			+ "WHERE EMPRESA_ID = ?1\r\n"
			+ "UNION ALL\r\n"
			+ "SELECT T.VALOR AS COMPROMETIMENTO FROM (SELECT * FROM TB_SOCIEDADE S\r\n"
			+ "INNER JOIN TB_PROPRIEDADE P ON S.EMPRESA_SOCIA_ID = P.EMPRESA_ID\r\n"
			+ "WHERE (S.EMPRESA_ID = ?1 AND S.EMPRESA_SOCIA_ID\r\n"
			+ "IS NOT NULL AND S.EMPRESA_SOCIA_ID != ?2) ) AS T) AS RESULT;", nativeQuery = true)
	Double consultarComprometimentoEmpresa(Long empresaId, Long empresaSociaId);

}
