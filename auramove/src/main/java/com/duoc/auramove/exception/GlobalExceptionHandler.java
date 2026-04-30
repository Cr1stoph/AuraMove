package com.duoc.auramove.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExeptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationError(MethodArgumentNotValidExcepttion ex){

        StringBuilder detalle = new StringBuilder();

        for (FieldError campo : ex.getBindingResult().getFieldErrors()){
            detalle.append(campo.getField()).append(", ").append(campo.getDefaultMessage()).append("; ");
        }
        ApiError error = new ApiError(400, "Error de validacion", detalle.toString());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericError(Exception ex) {
        ApiError error = new ApiError(500, "Error interno del servidor", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}