package com.duoc.auramove.service;

import java.util.List;
import com.duoc.auramove.model.Entrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoc.auramove.repository.EntrenamientoRepository;

@Service
public class EntrenamientoService {
    @Autowired
    private EntrenamientoRepository entrenamientoRepository;

    //Obtener lista de entrenamientos
    public List<Entrenamiento> getEntrenamiento(){
        return entrenamientoRepository.findAll();
    }
    //Guardar nuevo entrenamiento
    public Entrenamiento savEntrenamiento(Entrenamiento entrenamiento){
        return entrenamientoRepository.save(entrenamiento);
    }
    //Obtener entrenamiento por id
    public Entrenamiento getEntrenamientoById(Integer id){
        return entrenamientoRepository.findById(id).orElse(null);
    }
    //Actualizar Entrenamiento
    public Entrenamiento updEntrenamiento(Entrenamiento entrenamiento){
        if (!entrenamientoRepository.existsById(entrenamiento.getId())) {
            return null;
        }
        return entrenamientoRepository.save(entrenamiento);
    }
    // Eliminar Entrenamiento
    public void deleteEntrenamiento(Integer id){
        entrenamientoRepository.deleteById(id);
    }
    
}
