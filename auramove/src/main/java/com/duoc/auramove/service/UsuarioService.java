package com.duoc.auramove.service;
import com.duoc.auramove.Dto.UserEmailDTO;
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
    //Obtiene un usuario por id, si no existe lanza a error
    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
    //Valida si existe el usuario si no existe lanza a "Usuario no encontrado" 
    public Usuario updateUsuario(Usuario usuario) {
        Usuario existing = usuarioRepository.findById(usuario.getId()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        existing.setNombre(usuario.getNombre());
        existing.setEmail(usuario.getEmail());
        return usuarioRepository.save(existing);
    }
    //Elimina un usuario por id 
    public void deleteUsuario(Integer id){ 
        if (!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
    public List<UserEmailDTO> getUsuarioConEmail(){
        return usuarioRepository.findAll().stream()
            .map(l -> new UserEmailDTO(
                l.getNombre(),
                l.getApellido(),
                l.getEmail()
            ))
            .toList();
    }

}