package com.certus.edu.pe.controller;


import com.certus.edu.pe.exception.ExceptionNotFound;
import com.certus.edu.pe.model.Usuario;
import com.certus.edu.pe.repositorio.UsuarioRepositorio;
import com.certus.edu.pe.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/thegamezone/usuarios")
public class UsuarioController {

    @Autowired
    private UsuariosServices services;

    @GetMapping
    public ResponseEntity<Object> listarUsuarios() {
        List<Usuario>listaUsuarios = services.listarUsuario();
        return ResponseEntity.ok(listaUsuarios);
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> buscarUsuario(@PathVariable Long id) {
        Usuario usuario = services.buscarUsuario(id);
        if (usuario == null)
            throw new ExceptionNotFound("Usuario no encontrado");
        return ResponseEntity.ok(usuario);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> crearUsuario(@RequestBody Usuario usuario) {
        services.guardarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> actualizarUsuario(@PathVariable ("id")int id, @RequestBody Usuario usuario) {
        services.actualizarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable("id") Long id) {
        services.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado");
    }


}
