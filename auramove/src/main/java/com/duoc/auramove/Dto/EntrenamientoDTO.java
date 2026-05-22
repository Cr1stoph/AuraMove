package com.duoc.auramove.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrenamientoDTO {

    @NotBlank(message = "El nombre del entrenamiento es obligatorio [full body, espalda, etc.]")
    private String nombre;

    @NotNull(message = "La duracion es obligatoria")
    @Min(message = "La duracion minima es de 1 Minuto", value = 1)
    private Integer duracion;

    @NotNull(message = "El ID de la rutina es obligatorio")
    private Integer rutinaId;
}
