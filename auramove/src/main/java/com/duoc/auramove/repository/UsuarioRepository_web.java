package com.duoc.auramove.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.auramove.model.Usuario_web;

@Repository
public interface UsuarioRepository_web extends JpaRepository<Usuario_web, Integer>{
}
