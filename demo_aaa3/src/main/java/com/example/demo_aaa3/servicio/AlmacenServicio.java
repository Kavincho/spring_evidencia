package com.example.demo_aaa3.servicio;

import java.io.FileNotFoundException;
import java.nio.file.Path;

//import org.apache.tomcat.util.file.ConfigurationSource.Resource;
//import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

public interface AlmacenServicio {
    
    public void iniciarAlmacenDeArchivos();

    public String almacenarArchivo(MultipartFile archivo);

    public Path cargarArchivo(String nombreArchivo);
    
    public Resource  cargarComoRecurso(String nombreArchivo) throws FileNotFoundException;

    public void eliminarArchivo(String nombreArchivo);
}
