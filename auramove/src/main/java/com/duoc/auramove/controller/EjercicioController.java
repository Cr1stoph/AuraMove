package com.duoc.auramove.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.duoc.auramove.model.Ejercicio;
import com.duoc.auramove.service.EjercicioService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/v1/ejercicio")
public class EjercicioController {
    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping
    public ResponseEntity<List<Ejercicio>> getAllEjercicios(){
        System.out.println("[EjercicioController] -> getEjercicios");
        return ResponseEntity.ok(ejercicioService.getEjercicios());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ejercicio> getEjercicioById(@PathVariable Integer id){
        System.out.println("[EjercicioController] -> getEjercicioById id = "+id);
        Ejercicio ejercicio = ejercicioService.getEjercicioById(id);
        if (ejercicio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ejercicio);
    }
    @PostMapping
    public ResponseEntity<Ejercicio> saveEjercicio(@Valid @RequestBody Ejercicio ejercicio){
        System.out.println("[EjercicioController] -> saveEjercicio");
        return ResponseEntity.status(HttpStatus.CREATED).body(ejercicioService.saveEjercicio(ejercicio));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ejercicio> updateEjercicio(@PathVariable Integer id, @Valid @RequestBody Ejercicio ejercicio){
        System.out.println("[EjercicioController] -> updateEjercicio id = "+id);
        ejercicioService.deleteEjercicio(id);
        return ResponseEntity.noContent().build();
    }
}
