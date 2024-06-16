package com.certus.edu.pe.services;

import com.certus.edu.pe.exception.ExceptionNotFound;
import com.certus.edu.pe.model.Funko;
import com.certus.edu.pe.model.Producto;
import com.certus.edu.pe.repositorio.FunkoRepositorio;
import com.certus.edu.pe.repositorio.ProductoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FunkoServices {

    @Autowired
    public ProductoRepositorio productoRepositorio;
    public FunkoRepositorio repositorio;

    public List<Funko> lista(){
        return repositorio.findAll();
    }

    public Funko guardar(Funko funko){
        return repositorio.save(funko);
    }

    public Funko buscar(Integer id){
        return repositorio.findById(id).get();
    }

    public Funko actualizaSugerencias(Integer idFunko,Funko funko){

        Funko FunkoaActual =repositorio.findById(idFunko).get();
        FunkoaActual.setNombre(funko.getNombre());
        FunkoaActual.setFranquicia(funko.getFranquicia());
        FunkoaActual.setTamaño(funko.getTamaño());
        FunkoaActual.setProducto(funko.getProducto());
        Funko FunkoActualizado = repositorio.save(funko);

        if (funko.getProducto() != null && funko.getProducto().getId() != null) {
            Producto producto = productoRepositorio.findById(funko.getProducto().getId())
                    .orElseThrow(() -> new ExceptionNotFound("Producto not found with id " + funko.getProducto().getId()));
            funko.setProducto(producto);
        }


        return FunkoActualizado;
    }

    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }



}
