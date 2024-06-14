package com.certus.edu.pe.controller;


import com.certus.edu.pe.exception.ExceptionNotFound;
import com.certus.edu.pe.model.Comentario;
import com.certus.edu.pe.services.ComentarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thegamezone/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioServices services;

    @GetMapping
    public ResponseEntity<Object> listarComentarios(){
        List<Comentario> listAllComentario= services.listaComentarios();
        System.out.println("Lista de funciones"+listAllComentario);
        return ResponseEntity.ok(listAllComentario);
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object>buscarComentario(@PathVariable("id")Long id){
        Comentario comentario =services.buscaComentario(id);
        if (comentario == null)
            throw new ExceptionNotFound("Comentario no encontrado");
            return ResponseEntity.ok(comentario);
    }


    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> crearComentario(@RequestBody Comentario comentario){
        services.guardaComentario(comentario);
        return ResponseEntity.ok(comentario);
    }


    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> actualizarComentario(@PathVariable("id") Long id,@RequestBody Comentario comentario){
        services.actualizaComentario(comentario);
        return ResponseEntity.ok("Comentario actualizado");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminarComentario(@PathVariable("id") Long id){
        services.eliminaComentario(id);
        return ResponseEntity.ok("Comentario eliminado");
    }

    }


