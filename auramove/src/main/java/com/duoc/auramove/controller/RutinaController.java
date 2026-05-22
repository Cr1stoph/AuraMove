package com.duoc.auramove.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.auramove.service.RutinaService;

import jakarta.validation.Valid;

import com.duoc.auramove.Dto.RutinaDTO;
import com.duoc.auramove.model.Rutina;
import java.util.List;

@RestController
@RequestMapping("api/v1/rutina")
public class RutinaController {

    @Autowired
    private RutinaService rutinaService;

    @GetMapping
    public ResponseEntity<List<Rutina>> getAllrutinas(){
        System.out.println("[RutinaController] -> getAllRutinas");
        return ResponseEntity.ok(rutinaService.getRutina());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Rutina> getRutinaById(@PathVariable Integer id){
        System.out.println("[RutinaController] -> getRutinaById id = "+id);
        Rutina rutina = rutinaService.getRutinaById(id);
        if (rutina == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rutina);
    }
    @PostMapping
    public ResponseEntity<Rutina> saveRutina(@Valid @RequestBody RutinaDTO dto){
        System.out.println("[RutinaController] -> saveRutina");
        return ResponseEntity.status(HttpStatus.CREATED).body(rutinaService.saveRutina(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Rutina> updateRutina(@PathVariable Integer id, @Valid @RequestBody RutinaDTO dto) {
        System.out.println("[RutinaController] -> updateRutina id = " + id);
        Rutina actualizado = rutinaService.updateRutina(id, dto);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removRutina(@PathVariable Integer id){
        System.out.println("[RutinaController] -> removeRutina id = "+id);
        rutinaService.deleteRutina(id);
        return ResponseEntity.noContent().build();
    }
    
}
