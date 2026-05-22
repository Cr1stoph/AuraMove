package com.duoc.auramove.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.auramove.Dto.EjercicioDTO;
import com.duoc.auramove.model.Ejercicio;
import com.duoc.auramove.repository.EjercicioRepository;
import java.util.List;

@Service
public class EjercicioService {
    @Autowired
    private EjercicioRepository ejerciciorepository;

    // listar los ejercicios
    public List<Ejercicio> getEjercicios(){
        return ejerciciorepository.findAll();
    }
    //Guardar nuevo ejercicio
    public Ejercicio saveEjercicio(EjercicioDTO dto) {
        Ejercicio nuevoEjercicio = new Ejercicio();
        nuevoEjercicio.setNombre(dto.getNombre());
        nuevoEjercicio.setGrupoMuscular(dto.getGrupoMuscular());
        nuevoEjercicio.setDificultad(dto.getDificultad());
        nuevoEjercicio.setDescripcion(dto.getDescripcion());
        return ejerciciorepository.save(nuevoEjercicio);
    }
    // Buscar ejercicio por id
    public Ejercicio getEjercicioById(Integer id){
        return ejerciciorepository.findById(id).orElse(null);
    }
    //Actualiza nuevo ejercicio
    public Ejercicio updateEjercicio(Integer id, EjercicioDTO dto) {
        Ejercicio existente = ejerciciorepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }
        existente.setNombre(dto.getNombre());
        existente.setGrupoMuscular(dto.getGrupoMuscular());
        existente.setDificultad(dto.getDificultad());
        existente.setDescripcion(dto.getDescripcion());
        return ejerciciorepository.save(existente);
    }
    //Eliminar ejercicio
    public void deleteEjercicio(Integer id){
        ejerciciorepository.deleteById(id);
    }

    
}
