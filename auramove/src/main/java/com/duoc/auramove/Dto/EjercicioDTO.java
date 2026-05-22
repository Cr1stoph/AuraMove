package com.duoc.auramove.Dto;

import lombok.Data;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class EjercicioDTO {

    @NotBlank(message = "El nombre del ejercicio es obligatorio")
    private String nombre;

    @NotBlank(message = "El grupo muscular debe ser especificado")
    private String grupoMuscular;

    @NotNull(message = "La dificultad es obligatoria")
    @Min(value = 1, message = "La dificultad minima es 1")
    @Max(value = 5, message = "La dificultad máxima es de 5")
    private Integer dificultad;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;
}
