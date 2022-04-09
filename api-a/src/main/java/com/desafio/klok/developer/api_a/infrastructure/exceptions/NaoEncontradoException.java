package com.desafio.klok.developer.api_a.infrastructure.exceptions;

public class NaoEncontradoException extends Exception{
    

    public NaoEncontradoException(String mensagem){
        super(mensagem);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
