package com.certus.edu.pe.model;

import ch.qos.logback.core.model.NamedModel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@Table(name="funko")
public class Funko implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @JoinColumn(name = "idProducto",referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto producto;

    @Basic(optional = false)
    @Column(name="nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name="franquicia")
    private String franquicia;

    @Basic(optional = false)
    @Column(name="tamaño")
    private String tamaño;

    @Basic(optional = false)
    @Column(name="precio")
    private BigDecimal precio;

    public Funko() {

    }

    public Funko(Integer id, Producto producto, String nombre, String franquicia, String tamaño, BigDecimal precio) {
        this.id = id;
        this.producto = producto;
        this.nombre = nombre;
        this.franquicia = franquicia;
        this.tamaño = tamaño;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
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
        Funko funko = (Funko) o;
        return Objects.equals(id, funko.id) && Objects.equals(producto, funko.producto) && Objects.equals(nombre, funko.nombre) && Objects.equals(franquicia, funko.franquicia) && Objects.equals(tamaño, funko.tamaño) && Objects.equals(precio, funko.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, producto, nombre, franquicia, tamaño, precio);
    }

    @Override
    public String toString() {
        return "Funko{}";
    }
}
