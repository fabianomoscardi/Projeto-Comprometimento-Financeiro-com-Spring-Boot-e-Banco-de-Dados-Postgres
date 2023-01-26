package com.api.compromentimentofinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.compromentimentofinanceiro.models.EmpresaModel;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long> {

	@Query(value = "SELECT SUM(p.VALOR) AS \"COMPROMETIMENTO\" FROM  TB_PROPRIEDADE P\r\n"
			+ "INNER JOIN TB_SOCIEDADE S ON P.EMPRESA_ID = S.EMPRESA_ID\r\n"
			+ "WHERE S.EMPRESA_ID = ?;", nativeQuery = true)
	Double consultarComprometimentoEmpresa(Long empresaId);

}
