package com.duoc.auramove.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @NotBlank
    private String nombreUsuario;
    
    @NotBlank
    private String email;
   
    @NotBlank
    private String password;
    
    @NotBlank
    private String nivel;

    
}
