package com.duoc.auramove.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoc.auramove.model.Rutina;

import java.util.List;

import com.duoc.auramove.repository.RutinaRepository;

@Service
public class RutinaService {
    @Autowired
    private RutinaRepository rutinaRepository;
    //Obtener lista ed todas las sucursales
    public List<Rutina> getRutina(){
        return rutinaRepository.findAll();
    }
    //Registrar rutina
    public Rutina saveRutina(Rutina rutina){
        return rutinaRepository.save(rutina);
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
