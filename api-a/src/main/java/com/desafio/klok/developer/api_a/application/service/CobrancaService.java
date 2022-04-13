package com.desafio.klok.developer.api_a.application.service;

import com.desafio.klok.developer.api_a.domain.AdesaoModel;
import com.desafio.klok.developer.api_a.domain.CobrancaModel;
import com.desafio.klok.developer.api_a.infrastructure.exceptions.NaoEncontradoException;
import com.desafio.klok.developer.api_a.infrastructure.repository.CobrancaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CobrancaService {
    
    @Autowired
    private CobrancaRepository cobrancaRepository;

    @Autowired
    private AdesaoService adesaoService;

    public CobrancaModel cadastrar(CobrancaModel novaCobranca, Long idAdesao) throws NaoEncontradoException {
        AdesaoModel adesao = adesaoService.buscar(idAdesao);
        novaCobranca.cadastrarCobranca(adesao.getValor(), adesao);
        adesao.getListaCobrancas().add(novaCobranca);
        /*adesaoRepository.saveAndFlush(adesao);*/
        return novaCobranca = cobrancaRepository.save(novaCobranca);
    }

}
