package com.duoc.auramove.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    private Long id;

    private Integer duracion;



    @ManyToOne
    @JoinColumn(name = "rutina_id")
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
