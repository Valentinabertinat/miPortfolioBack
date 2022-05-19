package com.miPortfolio.miPortfolioWeb.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreProyecto;
    private String descripcion;
    private String url_foto;
    private String url_sitio;

    public Proyecto() {
    }

    public Proyecto(Long id, String nombreProyecto, String descripcion, String url_foto, String url_sitio) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.url_foto = url_foto;
        this.url_sitio = url_sitio;
    }

    public String getUrl_sitio() {
        return url_sitio;
    }

    public void setUrl_sitio(String url_sitio) {
        this.url_sitio = url_sitio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", nombreProyecto='" + nombreProyecto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", url_foto='" + url_foto + '\'' +
                ", url_sitio='" + url_sitio + '\'' +
                '}';
    }
}
