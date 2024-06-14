package com.certus.edu.pe.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Data
@Table(name= "usuario")
@NamedQueries({
        @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
        @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id=:id"),
        @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario=:nombreUsuario"),
        @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email=:email"),
        @NamedQuery(name = "Usuario.findByContraseña", query = "SELECT u FROM Usuario u WHERE u.contraseña=:contraseña")
})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long id;

    @Basic(optional = false)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @Column(name = "contraseña")
    private String contraseña;

    public Usuario() {

    }

    public Usuario(Long id, String nombreUsuario, String email, String contraseña) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contraseña = contraseña;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nombreUsuario, usuario.nombreUsuario) && Objects.equals(email, usuario.email) && Objects.equals(contraseña, usuario.contraseña);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreUsuario, email, contraseña);
    }

    @Override
    public String toString() {
        return "Usuario{}";
    }
}