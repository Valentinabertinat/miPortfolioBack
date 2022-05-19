package com.miPortfolio.miPortfolioWeb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String ubicacion;
    private String puesto;
    private String url_foto;
    private String url_foto_banner;

    public Persona() {}

    public Persona(Long id, String nombre, String correo, String ubicacion, String puesto, String url_foto, String url_foto_banner) {
        this.nombre = nombre;
        this.correo = correo;
        this.ubicacion = ubicacion;
        this.puesto = puesto;
        this.url_foto = url_foto;
        this.url_foto_banner = url_foto_banner;
    }

    public String getUrl_foto_banner() {
        return url_foto_banner;
    }

    public void setUrl_foto_banner(String url_foto_banner) {
        this.url_foto_banner = url_foto_banner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", puesto='" + puesto + '\'' +
                ", url_foto='" + url_foto + '\'' +
                '}';
    }
}
