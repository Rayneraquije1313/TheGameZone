package com.certus.edu.pe.services;

import com.certus.edu.pe.exception.ExceptionNotFound;
import com.certus.edu.pe.model.Funko;
import com.certus.edu.pe.model.Producto;
import com.certus.edu.pe.model.Usuario;
import com.certus.edu.pe.repositorio.FunkoRepositorio;
import com.certus.edu.pe.repositorio.ProductoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@Transactional
public class FunkoServices {

    @Autowired
    public FunkoRepositorio repositorio;

    public List<Funko> lista(){
        return repositorio.findAll();
    }

    public Funko guardar(Funko funko){
        return repositorio.save(funko);
    }

    public Funko buscar(Long id){
        return repositorio.findById(id).get();
    }

    public Funko actualizaSugerencias(Funko funko){

        Funko actual =repositorio.findById(funko.getId()).get();
        actual.setId(funko.getId());
        actual.setNombre(funko.getNombre());
        actual.setFranquicia(funko.getFranquicia());
        actual.setPrecio(funko.getPrecio());
        actual.setTamaño(funko.getTamaño());
        Funko FunkoActualizado = repositorio.save(funko);
        return FunkoActualizado;
    }

    public void eliminar(Long id){
        repositorio.deleteById(id);
    }

    public void actualizar(Long id, Funko funko) {
        Funko actual = repositorio.findById(id).get();
        actual.setId(funko.getId());
        actual.setNombre(funko.getNombre());
        actual.setFranquicia(funko.getFranquicia());
        actual.setPrecio(funko.getPrecio());
        actual.setTamaño(funko.getTamaño());
        repositorio.save(actual);
    }


}
