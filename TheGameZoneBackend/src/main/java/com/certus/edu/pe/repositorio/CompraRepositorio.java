package com.certus.edu.pe.repositorio;


import com.certus.edu.pe.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepositorio extends JpaRepository<Compra,Long> {
}
