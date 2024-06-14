package com.certus.edu.pe.services;

import com.certus.edu.pe.model.Comentario;
import com.certus.edu.pe.repositorio.ComentarioRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ComentarioServices {
    @Autowired
    public ComentarioRepositorio repositorio;

    public List <Comentario> listaComentarios(){
        return repositorio.findAll();
    }

    public Comentario guardaComentario(Comentario comentario){
        return repositorio.save(comentario);
    }

    public Comentario buscaComentario(Long id){
        return repositorio.findById(id).get();
    }

    public Comentario actualizaComentario(Comentario comentario){

        Comentario comentarioActual =repositorio.findById(comentario.getId()).get();
        comentarioActual.setId(comentario.getId());
        comentarioActual.setComentario(comentario.getComentario());

        Comentario comentarioActualizado = repositorio.save(comentario);
        return comentarioActualizado;
    }

    public void eliminaComentario(Long id){
        repositorio.deleteById(id);
    }

    public void actualizar(Long id, Comentario comentario){
        Comentario comentarioActualizado = repositorio.findById(id).get();
        comentarioActualizado.setComentario(comentario.getComentario());
        comentarioActualizado.setComentario(comentario.getComentario());
        repositorio.save(comentarioActualizado);
    }
}

