package com.certus.edu.pe.repositorio;


import com.certus.edu.pe.model.CompraProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraProductoRepositorio extends JpaRepository<CompraProducto,Long> {
}
