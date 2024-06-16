package com.certus.edu.pe.services;

import com.certus.edu.pe.model.Usuario;
import com.certus.edu.pe.repositorio.UsuarioRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuariosServices {

    @Autowired
    public UsuarioRepositorio repositorio;

    public List<Usuario> listarUsuario() {
        return repositorio.findAll();
    }

    public  Usuario guardarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    public Usuario buscarUsuario(Long id) {
        return repositorio.findById(id).get();
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioActual = repositorio.findById(usuario.getId()).get();
        usuarioActual.setId(usuario.getId());
        usuarioActual.setNombre(usuario.getNombre());
        usuarioActual.setApellido(usuario.getApellido());
        usuarioActual.setEmail(usuario.getEmail());
        usuario.setContraseña(usuario.getContraseña());
        usuarioActual.setUsername(usuario.getUsername());
        return usuarioActual;

    }
    public void eliminarUsuario(Long id) {
        repositorio.deleteById((id));
    }

    public void actualizar(Long id, Usuario usuario) {
        Usuario usuarioActual = repositorio.findById(id).get();
        usuarioActual.setId(usuario.getId());
        usuarioActual.setNombre(usuario.getNombre());
        usuarioActual.setApellido(usuario.getApellido());
        usuarioActual.setEmail(usuario.getEmail());
        usuario.setContraseña(usuario.getContraseña());
        usuarioActual.setUsername(usuario.getUsername());
        repositorio.save(usuarioActual);
    }
}
