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
import com.duoc.auramove.service.SucursalService;
import com.duoc.auramove.Dto.SucursalDTO;
import com.duoc.auramove.model.Sucursal;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/sucursales")
public class SucursalController {
    
    @Autowired
    private SucursalService sucursalService;

    @GetMapping
     public ResponseEntity<List<Sucursal>> listarSucursales(){
        System.out.println(("[SucursalController] -> listarSucursales"));
        return ResponseEntity.ok(sucursalService.getSucursales());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getSucursalById(@PathVariable Integer id){
        System.out.println("[SucursalController] -> getSucursalById id = "+id);
        Sucursal sucursal = sucursalService.getSucursalById(id);
        if(sucursal == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sucursal);
    }

    @PostMapping
    public ResponseEntity<Sucursal> saveSucursal(@Valid @RequestBody SucursalDTO dto){
        System.out.println("[SucursalController] -> agregarSucursal");
        Sucursal sucursalGuardada = sucursalService.saveSucursal(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalGuardada);   
    }


    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> updateSucursal(@PathVariable Integer id, @Valid @RequestBody SucursalDTO dto){
        System.out.println("[SucursalController] -> actualizaScursal id = "+id);
        Sucursal actualizado = sucursalService.updateSucursal(id, dto);
        if(actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeSucursal(@PathVariable Integer id){
        System.out.println("[SucursalController] -> eliminaSucursal id = "+ id);
        sucursalService.deleteSucursal(id);
        return ResponseEntity.noContent().build();
    }

}
