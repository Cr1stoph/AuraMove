package com.duoc.auramove.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucursalDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
    @NotBlank(message = "La ciudad es obligatoria")
    private String ciudad;
    @NotNull(message = "El ID del usuario es obligatorio")
    private Integer usuarioId;
}
