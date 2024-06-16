package com.certus.edu.pe.repositorio;


import com.certus.edu.pe.model.Sugerencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugerenciaRepositorio extends JpaRepository<Sugerencias,Long> {
}
