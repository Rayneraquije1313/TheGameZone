package com.certus.edu.pe.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Data
@Table(name= "comentarios")
@NamedQueries({
        @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
        @NamedQuery(name = "Comentario.findById", query = "SELECT c FROM Comentario c WHERE c.id=:id"),
        @NamedQuery(name ="Comentario.findByComentario", query = "SELECT c FROM Comentario c WHERE c.comentario=:comentario"),
})

public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name ="idComentario")
    private Long id;

    @Basic(optional = false)
    @Column(name ="comentario")
    private String comentario;

    @JoinColumn(name = "usuario",referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuario;


    public Comentario() {

    }

    public Comentario(Long id, String comentario, Usuario usuario) {
        this.id = id;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentario that = (Comentario) o;
        return Objects.equals(id, that.id) && Objects.equals(comentario, that.comentario) && Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comentario, usuario);
    }

    @Override
    public String toString() {
        return "Comentario{}";
    }
}
