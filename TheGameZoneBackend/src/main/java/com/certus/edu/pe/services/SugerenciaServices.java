package com.certus.edu.pe.services;

import com.certus.edu.pe.model.Sugerencias;
import com.certus.edu.pe.repositorio.SugerenciaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SugerenciaServices {

    @Autowired
    public SugerenciaRepositorio repositorio;

    public List<Sugerencias> listaSugerencias(){
        return repositorio.findAll();
    }

    public Sugerencias guardaSugerencias(Sugerencias sugerencias){
        return repositorio.save(sugerencias);
    }

    public Sugerencias buscaSugerencias(Long id){
        return repositorio.findById(id).get();
    }

    public Sugerencias actualizaSugerencias(Sugerencias sugerencias){

        Sugerencias sugerenciaActual =repositorio.findById(sugerencias.getId()).get();
        sugerenciaActual.setId(sugerencias.getId());
        sugerenciaActual.setSugerencia(sugerencias.getSugerencia());

        Sugerencias sugerenciasActualizado = repositorio.save(sugerencias);
        return sugerenciasActualizado;
    }

    public void eliminaSugerencias(Long id){
        repositorio.deleteById(id);
    }

    public void actualizar(Long id, Sugerencias sugerencias){
        Sugerencias sugerenciasActualizado = repositorio.findById(id).get();
        sugerenciasActualizado.getId(sugerencias.getId());
        sugerenciasActualizado.setSugerencia(sugerencias.getSugerencia());
        repositorio.save(sugerenciasActualizado);
    }
}
