package com.duoc.auramove.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RutinaDTO {

    @NotBlank(message = " El nombre de la rutina puede ser [Tren superior - tren inferior]")
    private String nombre;
    @NotBlank(message = "La descripcion no puede estar vacia")
    private String descripcion;
    
    @Min(value = 1, message = " el nivel minimo de la rutina es de 1")
    @Max(value = 5, message = "El nivel maximo de la rutina es de 5")
    private Integer nivel;
    @NotBlank(message = " El tipo de rutina es obligatorio [Cardio, fuerza, traccion, empuje, etc]")
    private String tipoRutina;
    @NotNull(message = "El Id del usuario es obligatorio")
    private Integer usuarioId;
    
}
