package com.api.compromentimentofinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.compromentimentofinanceiro.models.PropriedadeModel;

@Repository
public interface PropriedadeRepository extends JpaRepository<PropriedadeModel, Long> {

}
