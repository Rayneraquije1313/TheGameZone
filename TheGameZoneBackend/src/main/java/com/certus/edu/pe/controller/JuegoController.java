package com.certus.edu.pe.controller;


import com.certus.edu.pe.exception.ExceptionNotFound;
import com.certus.edu.pe.model.Funko;
import com.certus.edu.pe.model.Juego;
import com.certus.edu.pe.services.FunkoServices;
import com.certus.edu.pe.services.JuegoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/thegamezone/juego")
public class JuegoController {

    @Autowired
    private JuegoServices services;

    @GetMapping
    public ResponseEntity<Object>lista() {
        List<Juego>listar = services.lista();
        return ResponseEntity.ok(listar);
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> buscar(@PathVariable Long id) {
        Juego juego = services.buscar(id);
        if (juego == null)
            throw new ExceptionNotFound("no encontrado");
        return ResponseEntity.ok(juego);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> crear(@RequestBody Juego juego) {
        services.guardar(juego);
        return ResponseEntity.ok(juego);
    }

    @PutMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> actualizar(@PathVariable ("id")int id, @RequestBody Juego juego) {
        Juego actualizar = services.actualizaSugerencias(juego);
        return ResponseEntity.ok(actualizar);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Long id) {
        services.eliminar(id);
        return ResponseEntity.ok("eliminado");
    }


}
