package com.duoc.auramove.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

}
