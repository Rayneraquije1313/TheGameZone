package com.certus.edu.pe.controller;


import com.certus.edu.pe.exception.ExceptionNotFound;
import com.certus.edu.pe.model.Funko;
import com.certus.edu.pe.model.Producto;
import com.certus.edu.pe.services.FunkoServices;
import com.certus.edu.pe.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/thegamezone/funko")
public class FunkoController {

    @Autowired
    private FunkoServices services;

    @GetMapping
    public ResponseEntity<Object>lista() {
        List<Funko>listar = services.lista();
        return ResponseEntity.ok(listar);
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> buscar(@PathVariable Integer id) {
        Funko funko = services.buscar(id);
        if (funko == null)
            throw new ExceptionNotFound("no encontrado");
        return ResponseEntity.ok(funko);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> crear(@RequestBody Funko funko) {
        services.guardar(funko);
        return ResponseEntity.ok(funko);
    }

    @PutMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> actualizar(@PathVariable (value = "id")Integer idFunko, @RequestBody Funko funko) {
        Funko actualizar = services.actualizaSugerencias(idFunko,funko);
        return ResponseEntity.ok(actualizar);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        services.eliminar(id);
        return ResponseEntity.ok("eliminado");
    }


}
