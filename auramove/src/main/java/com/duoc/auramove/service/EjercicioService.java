package com.duoc.auramove.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.auramove.model.Ejercicio;
import com.duoc.auramove.repository.EjercicioRepository;
import java.util.List;

@Service
public class EjercicioService {
    @Autowired
    private EjercicioRepository ejerciciorepository;

    // listar los ejercicios
    private List<Ejercicio> getEjercicios(){
        return ejerciciorepository.findAll();
    }
    //Guardar nuevo ejercicio
    private Ejercicio saveEjercicio(Ejercicio ejercicio){
        return ejerciciorepository.save(ejercicio);
    }
    // Buscar ejercicio por id
    private Ejercicio getEjercicioById(Integer id){
        return ejerciciorepository.findById(id).orElse(null);
    }
    //Actualiza nuevo ejercicio
    private Ejercicio updateEjercio(Ejercicio ejercicio){
        if (!ejerciciorepository.existsById(ejercicio.getId())) {
            return null;
        }
        return ejerciciorepository.save(ejercicio);
    }
    //Eliminar ejercicio
    private void deleteEjercicio(Integer id){
        ejerciciorepository.deleteById(id);
    }

    
}
