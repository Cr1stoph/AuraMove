package com.duoc.auramove.service;
import com.duoc.auramove.Dto.SucursalDTO;
import com.duoc.auramove.model.Sucursal;
import com.duoc.auramove.model.Usuario;
import com.duoc.auramove.repository.SucursalRepository;
import com.duoc.auramove.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;
    //LLama a que se haga un nuevo objeto de usuariorepository para ligar las sucursales con el usuario
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Obtiene lista de todas las sucursales en la base de datos
    public List<Sucursal> getSucursales() {
        return sucursalRepository.findAll();
    }
    // Guarda una nueva sucursal
    public Sucursal saveSucursal(SucursalDTO dto){
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado id = " +dto.getUsuarioId()));
        Sucursal nuevaSucursal = new Sucursal();
        nuevaSucursal.setNombre(dto.getNombre());
        nuevaSucursal.setDireccion(dto.getDireccion());
        nuevaSucursal.setCiudad(dto.getCiudad());

        nuevaSucursal.setUsuario(usuario);
        return sucursalRepository.save(nuevaSucursal);
    }
    //Obtiene sucursal por id
    public Sucursal getSucursalById(Integer id) {
        return sucursalRepository.findById(id).orElse(null);
    }
    // Actualiza sucursal si es que existe
    public Sucursal updateSucursal(Integer id, SucursalDTO dto) {
        // Se verifica si la sucursal que se quiere editar existe
        Sucursal sucursalExiste = sucursalRepository.findById(id).orElse(null);
        if(sucursalExiste == null){
            return null; //si no existe el controlador devuelve un 404
        }
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
            .orElseThrow(()-> new RuntimeException("Usuario no encontrado id = "+dto.getUsuarioId()));

        sucursalExiste.setNombre(dto.getNombre());
        sucursalExiste.setDireccion(dto.getDireccion());
        sucursalExiste.setCiudad(dto.getCiudad());
        sucursalExiste.setUsuario(usuario);
        return sucursalRepository.save(sucursalExiste);
        
    }
// Eliminar sucursal
    public void deleteSucursal(Integer id){
        sucursalRepository.deleteById(id);
    }
}