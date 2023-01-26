package com.api.compromentimentofinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.compromentimentofinanceiro.models.SociedadeModel;

@Repository
public interface SociedadeRepository extends JpaRepository<SociedadeModel, Long> {

}
