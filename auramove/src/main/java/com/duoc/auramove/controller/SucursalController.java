package com.duoc.auramove.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.duoc.auramove.service.SucursalService;
import com.duoc.auramove.model.Sucursal;
import java.util.List;

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
    

}
