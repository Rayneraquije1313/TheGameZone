package com.certus.edu.pe.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@Table(name="producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long id;

    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;

    @JoinColumn(name = "funko",referencedColumnName = "idFunko",nullable = true)
    @ManyToOne(optional = true)
    private Funko funko;

    @JoinColumn(name = "juego",referencedColumnName = "idJuego",nullable = true)
    @ManyToOne(optional = true)
    private Juego juego;

    public Producto() {

    }

    public Producto(Long id, String tipo, Funko funko) {
        this.id = id;
        this.tipo = tipo;
        this.funko = funko;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funko getFunko() {
        return funko;
    }

    public void setFunko(Funko funko) {
        this.funko = funko;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) && Objects.equals(tipo, producto.tipo) && Objects.equals(funko, producto.funko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, funko);
    }

    @Override
    public String toString() {
        return "Producto{}";
    }
}
