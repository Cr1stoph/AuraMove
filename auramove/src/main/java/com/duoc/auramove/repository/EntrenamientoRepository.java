package com.duoc.auramove.repository;

import org.springframework.stereotype.Repository;
import com.duoc.auramove.model.Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Long> {

}