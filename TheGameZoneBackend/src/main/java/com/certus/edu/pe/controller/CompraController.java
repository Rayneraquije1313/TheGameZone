package com.certus.edu.pe.controller;


import com.certus.edu.pe.exception.ExceptionNotFound;
import com.certus.edu.pe.model.Compra;
import com.certus.edu.pe.model.Producto;
import com.certus.edu.pe.model.Usuario;
import com.certus.edu.pe.services.CompraServices;
import com.certus.edu.pe.services.ProductoServices;
import com.certus.edu.pe.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/thegamezone/compra")
public class CompraController {

    @Autowired
    private CompraServices services;

    @GetMapping
    public ResponseEntity<Object> listar() {
        List<Compra>listar = services.listar();
        return ResponseEntity.ok(listar);
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> buscar(@PathVariable Long id) {
        Compra Compra = services.buscar(id);
        if (Compra == null)
            throw new ExceptionNotFound("Usuario no encontrado");
        return ResponseEntity.ok(Compra);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> crear(@RequestBody Compra compra) {
        services.guardar(compra);
        return ResponseEntity.ok(compra);
    }

    @PutMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> actualizarUsuario(@PathVariable ("id")int id, @RequestBody Compra compra) {
        services.actualizar(compra);
        return ResponseEntity.ok(compra);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable("id") Long id) {
        services.eliminar(id);
        return ResponseEntity.ok("Usuario eliminado");
    }


}
