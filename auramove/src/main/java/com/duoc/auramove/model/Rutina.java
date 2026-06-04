package com.duoc.auramove.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "rutinas")
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre de la rutina puede ser [Tren superior - tren inferior]")
    private String nombre;

    @NotBlank(message = "La descripcion no puede estar vacia")
    private String descripcion;
    
    @Min(value = 1, message = "El nivel minimo de la rutina es de 1") 
    @Max(value = 5, message = "El nivel máximo de la rutina es de 5")
    private Integer nivel;
    //El tipo de rutina se refiere a si es de tipo cardio, tipo de fuerza, empuje etc.
    @NotBlank(message = "El tipo de rutina es obligatorio [Cardio, fuerza, traccion, empuje]")
    private String tipoRutina;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario_web usuario;

    //Una rutina tiene varios entrenamientos pero cada entrenamiento es parte de una rutina
    @JsonIgnore
    @OneToMany(mappedBy = "rutina", cascade = CascadeType.ALL)
    private List<Entrenamiento> entrenamientos;
}
