package com.duoc.auramove.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.auramove.Dto.RutinaDTO;
import com.duoc.auramove.model.Rutina;
import com.duoc.auramove.model.Usuario;

import java.util.List;

import com.duoc.auramove.repository.RutinaRepository;
import com.duoc.auramove.repository.UsuarioRepository;

@Service
public class RutinaService {
    @Autowired
    private RutinaRepository rutinaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    
    //Obtener lista ed todas las sucursales
    public List<Rutina> getRutina(){
        return rutinaRepository.findAll();
    }

    public Rutina saveRutina(RutinaDTO dto) {
        // 1. Buscamos al usuario
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + dto.getUsuarioId()));
        Rutina nuevaRutina = new Rutina();
        nuevaRutina.setNombre(dto.getNombre());
        nuevaRutina.setDescripcion(dto.getDescripcion());
        nuevaRutina.setNivel(dto.getNivel());
        nuevaRutina.setTipoRutina(dto.getTipoRutina());

        nuevaRutina.setUsuario(usuario);
        return rutinaRepository.save(nuevaRutina);
    }
    //Obtener rutina por id
    public Rutina getRutinaById(Integer Id){
        return rutinaRepository.findById(Id).orElse(null);
    }
    //Actualizar rutina por el id
    public Rutina updateRutina(Rutina rutina){
        if(!rutinaRepository.existsById(rutina.getId())){
            return null;
        }
        return rutinaRepository.save(rutina);
    }
    //Elimina rutina
    public void deleteRutina(Integer id){
        rutinaRepository.deleteById(id);
    }
}
