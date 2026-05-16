package com.duoc.auramove.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //Maneja errores de validacion (@valid falla) -> 400 bad Request
    //MethodArgumentNotValidException.class, esta diciendo: dame el objeto que represetna a esta clase
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationError(MethodArgumentNotValidException ex){
        // recorre todos los campos que fallaron la avalidacion y arma un mensaje
        StringBuilder detalle = new StringBuilder();

        for (FieldError campo : ex.getBindingResult().getFieldErrors()){
            detalle.append(campo.getField()) //Nombre del campo( ej: nombre)
            .append(", ")
            .append(campo.getDefaultMessage()) //Mensaje de la anotacion(no debe estar vacio)
            .append("; ");
        }
        ApiError error = new ApiError(400, "Error de validacion", detalle.toString());
        return ResponseEntity.badRequest().body(error);
    }
    //Maneja cualquier otra exepcion no esperada -> 500 Internal Server Error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericError(Exception ex) {
        ApiError error = new ApiError(500, "Error interno del servidor", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }    // Maneja errores de la API externa (Open Library) → 404 o 502
    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<ApiError> handleWebClientError(WebClientResponseException ex) {
        if (ex.getStatusCode().value() == 404) {
            ApiError error = new ApiError(404, "ISBN no encontrado en Open Library", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        ApiError error = new ApiError(502, "Error al consultar Open Library", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
    }
}