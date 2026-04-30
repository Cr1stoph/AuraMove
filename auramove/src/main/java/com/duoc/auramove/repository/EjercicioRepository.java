package com.duoc.auramove.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.duoc.auramove.model.Ejercicio;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> { 
}