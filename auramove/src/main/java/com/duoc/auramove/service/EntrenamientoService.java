package com.duoc.auramove.service;

import java.util.List;

import com.duoc.auramove.Dto.EntrenamientoDTO;
import com.duoc.auramove.model.Entrenamiento;
import com.duoc.auramove.model.Rutina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoc.auramove.repository.EntrenamientoRepository;
import com.duoc.auramove.repository.RutinaRepository;

@Service
public class EntrenamientoService {
    @Autowired
    private EntrenamientoRepository entrenamientoRepository;

    @Autowired
    private RutinaRepository rutinaRepository;

    //Obtener lista de entrenamientos
    public List<Entrenamiento> getEntrenamiento(){
        return entrenamientoRepository.findAll();
    }
    //Guardar nuevo entrenamiento
    public Entrenamiento saveEntrenamiento(EntrenamientoDTO dto) {
        Rutina rutina = rutinaRepository.findById(dto.getRutinaId())
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada con ID: " + dto.getRutinaId()));
        Entrenamiento nuevo = new Entrenamiento();
        nuevo.setNombre(dto.getNombre());
        nuevo.setDuracion(dto.getDuracion());
        nuevo.setRutina(rutina);
        return entrenamientoRepository.save(nuevo);
    }
    //Obtener entrenamiento por id
    public Entrenamiento getEntrenamientoById(Integer id){
        return entrenamientoRepository.findById(id).orElse(null);
    }
    //Actualizar Entrenamiento
    public Entrenamiento updEntrenamiento(Integer id, EntrenamientoDTO dto) {
        Entrenamiento existente = entrenamientoRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }
        Rutina rutina = rutinaRepository.findById(dto.getRutinaId())
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada con ID: " + dto.getRutinaId()));
        existente.setNombre(dto.getNombre());
        existente.setDuracion(dto.getDuracion());
        existente.setRutina(rutina); 
        return entrenamientoRepository.save(existente);
    }
    // Eliminar Entrenamiento
    public void deleteEntrenamiento(Integer id){
        entrenamientoRepository.deleteById(id);
    }
    
}
