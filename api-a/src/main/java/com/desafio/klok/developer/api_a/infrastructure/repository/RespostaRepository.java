package com.desafio.klok.developer.api_a.infrastructure.repository;

import com.desafio.klok.developer.api_a.domain.RespostaModel;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<RespostaModel, Long> {
    
}
