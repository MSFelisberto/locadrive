package br.com.fiap.locadrive.locadrive.controllers.handlers;

import br.com.fiap.locadrive.locadrive.dtos.ResourceNotFoundDTO;
import br.com.fiap.locadrive.locadrive.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundDTO> handlerResourceNotFoundException(ResourceNotFoundException e) {
        var status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status.value()).body(new ResourceNotFoundDTO(e.getMessage(), status.value()));
    }
}
