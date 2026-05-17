package com.duoc.auramove.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.auramove.service.EntrenamientoService;
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
    //@GetMapping("/[id}")
    //public ResponseEntity<Entrenamiento> getEntrenamientoById(@PathVariable Integer id){
    //    System.out.println("[EntrenamientoController] -> getEntrenamiento");
    //}
    
}
