package com.duoc.auramove.controller;

import java.util.List;
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
import com.duoc.auramove.Dto.UserEmailDTO;
import com.duoc.auramove.model.Usuario_web;
import com.duoc.auramove.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario_web>> getAllusuarios(){
        System.out.println("[UsuarioController] -> getAllUsuarios");
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario_web> getUsuarioById(@PathVariable Integer id){
        System.out.println("[UsuarioController] -> getUsuarioById id =" + id);
        Usuario_web usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario_web> saveUsuario(@Valid @RequestBody Usuario_web usuario){
        System.out.println("[UsuarioController] -> saveUsuario");
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuario));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario_web> updateUsuario(@PathVariable Integer id, @Valid @RequestBody Usuario_web usuario){
        System.out.println("[UsuarioController] -> updateUsuario id =" + id);
        usuario.setId(id);
        Usuario_web actualizado = usuarioService.updateUsuario(usuario);
        if(actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUsuario(@PathVariable Integer id){
        System.out.println("[UsuarioController] -> removeUsuario id =" + id);
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/com-email")
    public ResponseEntity<List<UserEmailDTO>> userPorEmail(){
        System.out.println("[UsuarioController] -> userPorEmail");
        return ResponseEntity.ok(usuarioService.getUsuarioConEmail());
    }
    //Endpoint que lanza una exepcion a proposito para uso de GlobalException
    @GetMapping("/test-error")
    public ResponseEntity<Usuario_web> testError() {
        System.out.println("[UsuarioController] -> testError");
        throw new RuntimeException("Este es un error de prueba lanzado intencionalmente");
    }

}
