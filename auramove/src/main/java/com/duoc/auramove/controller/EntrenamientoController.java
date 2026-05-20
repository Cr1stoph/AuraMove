package com.duoc.auramove.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.duoc.auramove.service.EntrenamientoService;

import jakarta.validation.Valid;

import com.duoc.auramove.model.Entrenamiento;
import java.util.List;


@RestController
@RequestMapping("api/v1/entrenamiento")
public class EntrenamientoController {
    @Autowired
    private EntrenamientoService entrenamientoService;

    @GetMapping
    public ResponseEntity<List<Entrenamiento>> getAllEntrenamientos(){
        System.out.println("[EntrenamientoController]");
        return ResponseEntity.ok(entrenamientoService.getEntrenamiento());
    }
    @GetMapping("/[id}")
    public ResponseEntity<Entrenamiento> getEntrenamientoById(@PathVariable Integer id){
        System.out.println("[EntrenamientoController] -> getEntrenamiento");
        Entrenamiento entrenamiento = entrenamientoService.getEntrenamientoById(id);
        if (entrenamiento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entrenamiento);
    }
    @PostMapping
    public ResponseEntity<Entrenamiento> saveEntrenamiento(@Valid @RequestBody Entrenamiento entrenamiento){
        System.out.println("[EntrenamientoController] -> saveEntrenamiento");
        return ResponseEntity.status(HttpStatus.CREATED).body(entrenamientoService.savEntrenamiento(entrenamiento));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Entrenamiento> updateEntrenamiento(@PathVariable Integer id, @Valid @RequestBody Entrenamiento entrenamiento){
        System.out.println("[EntrenamientoController] -> updateEntrenamiento id = " + id);
        entrenamiento.setId(id);
        Entrenamiento actualizado = entrenamientoService.updEntrenamiento(entrenamiento);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEntrenamiento(@PathVariable Integer id){
        System.out.println("[EntrenamientoController] -> eliminaEntrenamiento id = "+id);
        entrenamientoService.deleteEntrenamiento(id);
        return ResponseEntity.noContent().build();
    }
}
