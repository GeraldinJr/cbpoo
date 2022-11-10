package br.com.cbpoo.exceptions;

public class InvalidCPFException extends RuntimeException{
    public InvalidCPFException() {
        super("CPF invalido");
    }
}
