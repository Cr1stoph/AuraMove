package com.duoc.auramove.repository;

import org.springframework.stereotype.Repository;
import com.duoc.auramove.model.Rutina;
import or.sgpringframework.data.jpa.repository.JpaRepository;


@Repository
public interface RutinaRepository extends JpaRepository<Rutina, Long> {

}
