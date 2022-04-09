package com.desafio.klok.developer.api_a.infrastructure.exceptions;

public class EncontradoException extends Exception{
    

    public EncontradoException(String mensagem){
        super(mensagem);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
