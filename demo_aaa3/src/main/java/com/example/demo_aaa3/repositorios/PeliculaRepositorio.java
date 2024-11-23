package com.example.demo_aaa3.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_aaa3.modelo.pelicula;

public interface PeliculaRepositorio extends JpaRepository<pelicula,Integer>{
    
}
