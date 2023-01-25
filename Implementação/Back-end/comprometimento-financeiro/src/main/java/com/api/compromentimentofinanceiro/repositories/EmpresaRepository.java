package com.api.compromentimentofinanceiro.repositories;

import java.rmi.server.UID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.compromentimentofinanceiro.models.EmpresaModel;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, UID>{

	List<EmpresaModel> findByCnpj(Integer cnpj);
	
}
