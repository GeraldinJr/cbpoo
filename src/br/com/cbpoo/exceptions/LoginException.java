package br.com.cbpoo.exceptions;

public class LoginException extends RuntimeException{
    public LoginException() {
        super("Dados de login incorretos");
    }
}
