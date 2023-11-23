package br.jus.tjms.empresa.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(RegisterAlteradyExists.class)
    public ResponseEntity<RestError> capturaRegisterAlteradyExistsException(Exception ex) {
        return ResponseEntity.unprocessableEntity().body(new RestError(
                "0001", "Não foi possível processar seu pedido"));

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> capturaRuntimeException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.internalServerError().body(new RestError(
                "9999", "Requesição deu problema"));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> capturaMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(new RestError(
                "0002", ex.getBindingResult().getFieldError().getDefaultMessage()));

    }

    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> capturaConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.badRequest().body(new RestError(
                "0002", ex.getLocalizedMessage()));

    }

    protected record RestError(String code, String message) {
    }

}
