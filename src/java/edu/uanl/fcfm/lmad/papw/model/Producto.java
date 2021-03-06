/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uanl.fcfm.lmad.papw.model;

import java.io.InputStream;

/**
 *
 * @author Alberto
 */
public class Producto {
    int idProducto;
    int idAnuncio;
    String nombre;
    float precio;
    int existencia;
    String fecha;
    String descripcionLarga;
    InputStream imagen1;
    InputStream imagen2;
    InputStream imagen3;
    String video1;
    String video2;
    String video3;
    int idSubcategoria;
    int idUsuario;
    int comprasPendientes;
    int preguntasPendientes;
    
    boolean setImagen1;
    boolean setImagen2;
    boolean setImagen3;

    public Producto() {}

    public Producto(Producto p) {
        this.idProducto = p.idProducto;
        this.nombre = p.nombre;
        this.precio = p.precio;
        this.fecha = p.fecha;
        this.descripcionLarga = p.descripcionLarga;
        this.idSubcategoria = p.idSubcategoria;
        this.existencia = p.existencia;
        this.imagen1 = p.imagen1;
        this.imagen2 = p.imagen2;
        this.imagen3 = p.imagen3;
        this.video1 = p.video1;
        this.video2 = p.video2;
        this.video3 = p.video3;
        this.idAnuncio = p.idAnuncio;
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public InputStream getImagen1() {
        return imagen1;
    }

    public void setImagen1(InputStream imagen1) {
        this.imagen1 = imagen1;
    }

    public InputStream getImagen2() {
        return imagen2;
    }

    public void setImagen2(InputStream imagen2) {
        this.imagen2 = imagen2;
    }

    public InputStream getImagen3() {
        return imagen3;
    }

    public void setImagen3(InputStream imagen3) {
        this.imagen3 = imagen3;
    }

    public String getVideo1() {
        return video1;
    }

    public void setVideo1(String video1) {
        this.video1 = video1;
    }

    public String getVideo2() {
        return video2;
    }

    public void setVideo2(String video2) {
        this.video2 = video2;
    }

    public String getVideo3() {
        return video3;
    }

    public void setVideo3(String video3) {
        this.video3 = video3;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getComprasPendientes() {
        return comprasPendientes;
    }

    public void setComprasPendientes(int comprasPendientes) {
        this.comprasPendientes = comprasPendientes;
    }

    public int getPreguntasPendientes() {
        return preguntasPendientes;
    }

    public void setPreguntasPendientes(int preguntasPendientes) {
        this.preguntasPendientes = preguntasPendientes;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public boolean isSetImagen1() {
        return setImagen1;
    }

    public void setSetImagen1(boolean setImagen1) {
        this.setImagen1 = setImagen1;
    }

    public boolean isSetImagen2() {
        return setImagen2;
    }

    public void setSetImagen2(boolean setImagen2) {
        this.setImagen2 = setImagen2;
    }

    public boolean isSetImagen3() {
        return setImagen3;
    }

    public void setSetImagen3(boolean setImagen3) {
        this.setImagen3 = setImagen3;
    }
    
}
