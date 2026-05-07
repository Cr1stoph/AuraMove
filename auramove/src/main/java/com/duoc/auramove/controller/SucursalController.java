package com.duoc.auramove.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.auramove.service.SucursalService;

@RestController
@RequestMapping("/api/v1/sucursales")
public class SucursalController {
    
    @Autowired
    private SucursalService sucursalService;
}
