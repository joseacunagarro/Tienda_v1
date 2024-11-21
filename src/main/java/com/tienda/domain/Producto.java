/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="Producto")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id_Producto")
    private Long idProducto;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    private String detalle;
    private double precio;
    //private Long idCategoria;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    Categoria categoria;

    public Producto() {
    }

    public Producto(String Producto, boolean activo) {
        this.descripcion = Producto;
        this.activo = activo;
    }

}