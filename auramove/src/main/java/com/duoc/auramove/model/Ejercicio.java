package com.duoc.auramove.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ejercicios")
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @NotBlank(message = "El nombre del ejercicio es obligatorio")
    private String nombre;
    
    @NotBlank(message = "El grupo muscular debe ser especificado")
    private String grupoMuscular;
   
    @NotBlank(message = "La dificultad es obligatoria")
    @Min(value = 1, message = "La dificultad minima es 1")
    @Max(value = 5, message = "La dificultad máxima es de 5")
    private String dificultad;
    
    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "ejercicios")
    private List<Entrenamiento> entrenamientos;
}
