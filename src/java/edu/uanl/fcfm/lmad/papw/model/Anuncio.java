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
public class Anuncio {
    int idAnuncio;
    int idProducto;
    int thumbnailAnuncio;
    String fecha;
    String vigencia;
    InputStream imagen1;
    InputStream imagen2;
    InputStream imagen3;
    String video1;
    String video2;
    String video3;
    String metodoPago;
    
    
    String nombre;
    float precio;
    String caracteristicas;
    
    int existencias;
    String nickUsuario;
    String correoElectronico;
    String telefono;
    String nombreUsuario;
    
    int idUsuario;
    
    int idSubcategoria;
    
    int diasVigencia;
    
    public Anuncio(){}
    
    public Anuncio (Anuncio a)
    {
        this.nombre = a.nombre;
        this.precio = a.precio;
        this.caracteristicas = a.caracteristicas;
        this.correoElectronico = a.correoElectronico;
        this.existencias = a.existencias;
        this.vigencia = a.vigencia;
        this.telefono = a.telefono;
        this.nombreUsuario = a.nombreUsuario;
        this.fecha = a.fecha;
        this.nickUsuario = a.nickUsuario;
        this.metodoPago = a.metodoPago;
        this.idUsuario = a.idUsuario;
        this.thumbnailAnuncio = a.thumbnailAnuncio;
        this.idProducto = a.idProducto;
        this.imagen1 = a.imagen1;
        this.imagen2 = a.imagen2;
        this.imagen3 = a.imagen3;
        this.video1 = a.video1;
        this.video2 = a.video2;
        this.video3 = a.video3;
        this.diasVigencia = a.diasVigencia;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idProducto) {
        this.idAnuncio = idProducto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
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

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
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

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getNickUsuario() {
        return nickUsuario;
    }

    public void setNickUsuario(String nickUsuario) {
        this.nickUsuario = nickUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getThumbnailAnuncio() {
        return thumbnailAnuncio;
    }

    public void setThumbnailAnuncio(int thumbnailAnuncio) {
        this.thumbnailAnuncio = thumbnailAnuncio;
    }

    public int getDiasVigencia() {
        return diasVigencia;
    }

    public void setDiasVigencia(int diasVigencia) {
        this.diasVigencia = diasVigencia;
    }
    
}
