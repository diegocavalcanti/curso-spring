package br.jus.tjms.empresa.infra.exception;

public class RegisterAlteradyExists extends RuntimeException {

    public RegisterAlteradyExists(String message){
        super(message);
    }
    
}
