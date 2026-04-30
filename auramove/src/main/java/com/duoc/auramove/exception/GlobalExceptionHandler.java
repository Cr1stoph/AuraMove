package com.duoc.auramove.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //Maneja errores de validacion (@valid falla) -> 400 bad Request
    //MethodArgumentNotValidException.class, esta diciendo: dame el objeto que represetna a esta clase
    @ExeptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationError(MethodArgumentNotValidExcepttion ex){
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
    }
}