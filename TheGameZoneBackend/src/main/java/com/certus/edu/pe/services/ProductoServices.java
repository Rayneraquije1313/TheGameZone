package com.certus.edu.pe.services;

import com.certus.edu.pe.model.Compra;
import com.certus.edu.pe.model.Producto;
import com.certus.edu.pe.repositorio.CompraRepositorio;
import com.certus.edu.pe.repositorio.ProductoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductoServices {

    @Autowired
    public ProductoRepositorio repositorio;

    public List<Producto> listar(){
        return repositorio.findAll();
    }

    public Producto guardar(Producto producto){
        return repositorio.save(producto);
    }

    public Producto buscar(Long id){
        return repositorio.findById(id).get();
    }

    public Producto actualizar(Producto producto){

        Producto productoActual =repositorio.findById(producto.getId()).get();
        productoActual.setId(producto.getId());
        productoActual.setTipo(producto.getTipo());
        Producto productoActualizado = repositorio.save(producto);
        return productoActualizado;
    }

    public void eliminar(Long id){
        repositorio.deleteById(id);
    }

    public void actualizar(Long id, Producto producto){
        Producto productoActualizado = repositorio.findById(id).get();
        productoActualizado.setId(producto.getId());
        productoActualizado.setTipo(producto.getTipo());
        productoActualizado.setFunko(producto.getFunko());
        repositorio.save(productoActualizado);
    }
}
