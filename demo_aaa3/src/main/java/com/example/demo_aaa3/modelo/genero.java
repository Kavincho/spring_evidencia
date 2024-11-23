package com.example.demo_aaa3.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class genero {

    @Id
    @Column(name = "id_genero")
    private Integer id;

    private  String titulo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public genero(Integer id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public genero() {
    }

    public genero(Integer id) {
        this.id = id;
    }

    public genero(String titulo) {
        this.titulo = titulo;
    }

    
    
}
