package com.certus.edu.pe.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Data
@Table(name= "sugerencias")
public class Sugerencias implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name ="idSugerencias")
    private Long id;

    @JoinColumn(name = "usuario",referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    @Basic(optional = false)
    @Column(name ="sugerencia")
    private String sugerencia;

    @CreationTimestamp
    private LocalDateTime fechaSugerencia;


    public Sugerencias() {

    }

    public Sugerencias(Long id, Usuario usuario, String sugerencia, LocalDateTime fechaSugerencia) {
        this.id = id;
        this.usuario = usuario;
        this.sugerencia = sugerencia;
        this.fechaSugerencia = fechaSugerencia;
    }

    public Long getId(Long id) {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

    public LocalDateTime getFechaSugerencia() {
        return fechaSugerencia;
    }

    public void setFechaSugerencia(LocalDateTime fechaSugerencia) {
        this.fechaSugerencia = fechaSugerencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sugerencias that = (Sugerencias) o;
        return Objects.equals(id, that.id) && Objects.equals(usuario, that.usuario) && Objects.equals(sugerencia, that.sugerencia) && Objects.equals(fechaSugerencia, that.fechaSugerencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, sugerencia, fechaSugerencia);
    }

    @Override
    public String toString() {
        return "Sugerencias{}";
    }
}

