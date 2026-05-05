package com.duoc.auramove.service;
import com.duoc.auramove.model.Usuario;
import com.duoc.auramove.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    //Obtiene lista de todos los usuarios en la base de datos
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }
    //Crea un nuevo usuario y lo guarda en la base de datos
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    //Obtiene un usuario por id, si no existe retorna null
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    //Actualiza un usuario y si no existe, retorna null
    public Usuario updateUsuario(Usuario usuario) {
        if(!usuarioRepository.existsById(usuario.getId())) {
            return null;
        }
        return usuarioRepository.save(usuario);
    }
    //Elimina un usuario por id 
    public void deleteUsuario(Long id){ 
        usuarioRepository.deleteById(id);
    }

}