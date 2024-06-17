package com.certus.edu.pe.repositorio;


import com.certus.edu.pe.model.Compra;
import com.certus.edu.pe.model.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepositorio extends JpaRepository<Juego,Long> {
}
