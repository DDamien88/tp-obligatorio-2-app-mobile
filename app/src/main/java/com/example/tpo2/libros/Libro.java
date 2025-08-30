package com.example.tpo2.libros;

import java.io.Serializable;

public class Libro implements Serializable {
    private String titulo;
    private String isnb;

    private String autor;
    private String editorial;
    private String descripcion;
    private String etiqueta;
    private int anio;
    private int paginas;

    public Libro(String titulo, String isnb, String autor, String editorial, String descripcion, String etiqueta, int anio, int paginas) {
        this.titulo = titulo;
        this.isnb = isnb;
        this.autor = autor;
        this.editorial = editorial;
        this.descripcion = descripcion;
        this.etiqueta = etiqueta;
        this.anio = anio;
        this.paginas = paginas;
    }

    public Libro() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsnb() {
        return isnb;
    }

    public void setIsnb(String isnb) {
        this.isnb = isnb;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
}
