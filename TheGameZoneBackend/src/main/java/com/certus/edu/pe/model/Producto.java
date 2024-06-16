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
    private int tipo;

    @Basic(optional = false)
    @Column(name = "descripcion")
    private int descripcion;

    public Producto() {

    }

    public Producto(Long id, int tipo, int descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return tipo == producto.tipo && descripcion == producto.descripcion && Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, descripcion);
    }

    @Override
    public String toString() {
        return "Producto{}";
    }
}
