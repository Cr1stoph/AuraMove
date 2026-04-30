package com.duoc.auramove.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String email;

    //Un usuario puede tener muchas sucursales y cada sucursal pertenece a un único usuario
    @OneToMany(mappedBy = "usuario")
    private List<Sucursal> sucursales;

    //Un usuario tiene muchas rutinas pero cada rutina pertenece a un usuario
    @OneToMany(mappedBy = "usuario")
    private List<Rutina> rutinas;
}