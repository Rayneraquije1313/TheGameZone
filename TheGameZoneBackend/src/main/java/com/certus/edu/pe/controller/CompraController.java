package com.certus.edu.pe.controller;


import com.certus.edu.pe.exception.ExceptionNotFound;
import com.certus.edu.pe.model.Producto;
import com.certus.edu.pe.model.Usuario;
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
    private ProductoServices services;

    @GetMapping
    public ResponseEntity<Object> listar() {
        List<Producto>listar = services.listar();
        return ResponseEntity.ok(listar);
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> buscar(@PathVariable Long id) {
        Producto producto = services.buscar(id);
        if (producto == null)
            throw new ExceptionNotFound("Usuario no encontrado");
        return ResponseEntity.ok(producto);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> crear(@RequestBody Producto producto) {
        services.guardar(producto);
        return ResponseEntity.ok(producto);
    }

    @PutMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> actualizarUsuario(@PathVariable ("id")int id, @RequestBody Producto producto) {
        services.actualizar(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable("id") Long id) {
        services.eliminar(id);
        return ResponseEntity.ok("Usuario eliminado");
    }


}
