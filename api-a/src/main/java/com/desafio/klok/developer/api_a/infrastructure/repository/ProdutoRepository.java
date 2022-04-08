package com.desafio.klok.developer.api_a.infrastructure.repository;

import com.desafio.klok.developer.api_a.domain.ProdutoModel;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    
}
