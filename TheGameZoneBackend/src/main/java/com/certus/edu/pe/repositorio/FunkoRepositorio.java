package com.certus.edu.pe.repositorio;


import com.certus.edu.pe.model.Funko;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunkoRepositorio extends JpaRepository<Funko,Integer> {
}
