package com.duoc.auramove.model;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Table(name = "ejercicios")
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

    @ManyToMany(mappedBy = "ejercicios")
    private List<Entrenamiento> entrenamientos;
}
