package com.duoc.auramove.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entrenamientos")
public class Entrenamiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //nombre del dia o sesion. ej: "dia de pierna", "full body"
    @NotBlank(message = "El nombre del entramiento es obligatorio [full body, espada, etc.]")
    private String nombre; 

    //duracion de la sesion en minutos
    @NotNull(message = "La duracion es obligatoria")
    @Min(message = "La duracion minima es de 1 Minuto", value = 1)
    private Integer duracion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "rutina_id", nullable = false)
    private Rutina rutina;

    //Un entrenamiento tiene varios ejercicios pero y un ejercicio puede estar en varios entrenamientos
    @ManyToMany
    @JoinTable(
        name = "entrenamiento_ejercicio",
        joinColumns = @JoinColumn(name = "entrenamiento_id"),
        inverseJoinColumns = @JoinColumn(name = "ejercicio_id")
    )
    private List<Ejercicio> ejercicios;
}
