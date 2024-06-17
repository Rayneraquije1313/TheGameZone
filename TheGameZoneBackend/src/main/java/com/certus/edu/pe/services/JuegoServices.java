package com.certus.edu.pe.services;

import com.certus.edu.pe.model.Funko;
import com.certus.edu.pe.model.Juego;
import com.certus.edu.pe.repositorio.FunkoRepositorio;
import com.certus.edu.pe.repositorio.JuegoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class JuegoServices {

    @Autowired
    public JuegoRepositorio repositorio;

    public List<Juego> lista(){
        return repositorio.findAll();
    }

    public Juego guardar(Juego juego){
        return repositorio.save(juego);
    }

    public Juego buscar(Long id){
        return repositorio.findById(id).get();
    }

    public Juego actualizaSugerencias(Juego juego){

        Juego actual =repositorio.findById(juego.getId()).get();
        actual.setId(juego.getId());
        actual.setNombre(juego.getNombre());
        actual.setDesarrolladora(juego.getDesarrolladora());
        actual.setGenero(juego.getGenero());
        actual.setPrecio(juego.getPrecio());
        actual.setConsola(juego.getConsola());
        Juego actualizado = repositorio.save(juego);
        return actualizado;
    }

    public void eliminar(Long id){
        repositorio.deleteById(id);
    }

    public void actualizar(Long id, Juego juego) {
        Juego actual = repositorio.findById(id).get();
        actual.setId(juego.getId());
        actual.setNombre(juego.getNombre());
        actual.setDesarrolladora(juego.getDesarrolladora());
        actual.setGenero(juego.getGenero());
        actual.setPrecio(juego.getPrecio());
        actual.setConsola(juego.getConsola());
        repositorio.save(actual);
    }


}
