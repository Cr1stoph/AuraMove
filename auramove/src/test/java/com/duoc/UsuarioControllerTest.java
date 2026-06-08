package com.duoc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.duoc.auramove.controller.UsuarioController;
import com.duoc.auramove.model.Usuario;
import com.duoc.auramove.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {
    
    @Mock
    private UsuarioService usuarioservice;

    @InjectMocks
    private UsuarioController usuariocontroller;

    @Test
    void crearUsuario_retorna201_cuandoExisteUsuario() {

        Usuario usuario = new Usuario(1, "Carlos", "carl1234");

        when(UsuarioService.saveLibro(usuario)).thenReturn(usuario);

        var respuesta = UsuarioController.agregarLibro(usuario);

        assertNotNull(respuesta);

        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

        var body = respuesta.getBody();
        assertNotNull(body);

        assertEquals("Cien años de soledad", body.getTitulo());
    }
}
