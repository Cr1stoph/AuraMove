package com.duoc.auramove.service;
import com.duoc.auramove.model.Sucursal;
import com.duoc.auramove.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;
    //Obtiene lista de todas las sucursales en la base de datos
    public List<Sucursal> getSucursales() {
        return sucursalRepository.findAll();
    }
    // Guarda una nueva sucursal
    public Sucursal saveSucursal(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }
    //Obtiene sucursal por id
    public Sucursal getSucursalById(Integer id) {
        return sucursalRepository.findById(id).orElse(null);
    }
    // Actualiza sucursal si es que existe
    public Sucursal updateSucursal(Sucursal sucursal) {
        if(!sucursalRepository.existsById(sucursal.getId())) {
            return null;
        }
        return sucursalRepository.save(sucursal);
    }
// Eliminar sucursal
    public void deleteSucursal(Integer id){
        sucursalRepository.deleteById(id);
    }
}