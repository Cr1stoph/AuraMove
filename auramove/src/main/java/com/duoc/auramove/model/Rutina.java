package com.duoc.auramove.model;

import java.util.List;

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
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;
    
    @Min(value = 1, message = "El nivel minimo de la rutina es de 1") 
    @Max(value = 5, message = "El nivel máximo de la rutina es de 5")
    private Integer nivel;

    @NotBlank
    private String tipoRutina;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    //Una rutina tiene varios entrenamientos pero cada entrenamiento es parte de una rutina
    @OneToMany(mappedBy = "rutina")
    private List<Entrenamiento> entrenamientos;
}
