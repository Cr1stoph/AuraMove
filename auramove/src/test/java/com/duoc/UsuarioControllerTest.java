package com.duoc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.duoc.auramove.controller.UsuarioController;
import com.duoc.auramove.model.Usuario_web;
import com.duoc.auramove.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {
    
    @Mock
    private UsuarioService usuarioservice;

    @InjectMocks
    private UsuarioController usuariocontroller;

    @Test
    void crearUsuario_retorna201_cuandoExisteUsuario() {

        Usuario_web usuario = new Usuario_web(1, "Javier", "Valencia", "java1234@gmail.com", "jav1234", 22, null, null);

        when(usuarioservice.saveUsuario(usuario)).thenReturn(usuario);

        var respuesta = usuariocontroller.saveUsuario(usuario);

        assertNotNull(respuesta);

        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

        var body = respuesta.getBody();
        assertNotNull(body);

        assertEquals("Javier", body.getNombre());
    }

    //Prueba para usuario que ya existe
    @Test
    void crearUsuario_retorna409_cuandoElEmailYaExiste() {

        Usuario_web usuarioRepetido = new Usuario_web(2, "Luis", "Perez", "java1234@gmail.com", "luis123", 30, null, null);
    
        when(usuarioservice.saveUsuario(usuarioRepetido))
            .thenThrow(new IllegalArgumentException("El email ya está registrado"));

        assertThrows(IllegalArgumentException.class, () -> {
            usuariocontroller.saveUsuario(usuarioRepetido);
        });
    }

    //Prueba para nombre null
    @Test
    void crearUsuario_retorna400_cuandoElNombreEsNulo() {

        Usuario_web usuarioInvalido = new Usuario_web(3, null, "Gomez", "gomez@gmail.com", "123", 25, null, null);
    
        when(usuarioservice.saveUsuario(usuarioInvalido))
            .thenThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre es obligatorio"));

        assertThrows(ResponseStatusException.class, () -> {
            usuariocontroller.saveUsuario(usuarioInvalido);
        });
    }
}
