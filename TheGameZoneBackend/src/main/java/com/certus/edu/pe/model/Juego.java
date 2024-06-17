package com.certus.edu.pe.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@Table(name="juego")
public class Juego implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idJuego")
    private Long id;

    @Basic(optional = false)
    @Column(name="nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name="desarrolladora")
    private String desarrolladora;

    @Basic(optional = false)
    @Column(name="genero")
    private String genero;

    @Basic(optional = false)
    @Column(name="consola")
    private String consola;

    @Basic(optional = false)
    @Column(name="precio")
    private BigDecimal precio;

    public Juego() {

    }

    public Juego(Long id, String nombre, String desarrolladora, String genero, String consola, BigDecimal precio) {
        this.id = id;
        this.nombre = nombre;
        this.desarrolladora = desarrolladora;
        this.genero = genero;
        this.consola = consola;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Juego juego = (Juego) o;
        return Objects.equals(id, juego.id) && Objects.equals(nombre, juego.nombre) && Objects.equals(desarrolladora, juego.desarrolladora) && Objects.equals(genero, juego.genero) && Objects.equals(consola, juego.consola) && Objects.equals(precio, juego.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, desarrolladora, genero, consola, precio);
    }

    @Override
    public String toString() {
        return "Funko{}";
    }
}
