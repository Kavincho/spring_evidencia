package com.example.demo_aaa3.servicio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
//import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo_aaa3.ecepciones.AlmacenEception;
import jakarta.annotation.PostConstruct;

//import org.apache.tomcat.util.file.ConfigurationSource.Resource;
/* import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.*; */




@Service
public class AlmacenServicioImpl implements AlmacenServicio {

    @Value("${storage.location}")
    private String storageLocation;

// incaremos el metodo es se va a ejeciutar cuando se cree una nueva intancia

    @PostConstruct    	
    @Override
    public void iniciarAlmacenDeArchivos() {
        try{

            Files.createDirectories(Paths.get(storageLocation));
        }catch (IOException exception){
            throw new  AlmacenEception("error al iniciar la ubicaciond e los archivos");
        }
    }

    @Override
    public String almacenarArchivo(MultipartFile archivo) {
        String nombrearchivo = archivo.getOriginalFilename();
        if(archivo.isEmpty()){
            throw new AlmacenEception("no se puede almacenar un archivo vacio");
        }

        try {
            InputStream inputStream = archivo.getInputStream();
            Files.copy(inputStream, Paths.get(storageLocation).resolve(nombrearchivo),StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception exception) {
            throw new AlmacenEception("ERROR AL ALMACENAR ARCHIVO"+ nombrearchivo);
        }
        return nombrearchivo;
    }

    @Override
    public Path cargarArchivo(String nombreArchivo) {
        return Paths.get(storageLocation).resolve(nombreArchivo);
    }

    @Override
    public Resource cargarComoRecurso(String nombreArchivo) throws FileNotFoundException {
        try {
            Path archivo = cargarArchivo(nombreArchivo);
            org.springframework.core.io.Resource recurso = new UrlResource(archivo.toUri());
    
            if(recurso.exists()|| recurso.isReadable()){
                return recurso;
            }else{
                throw new FileNotFoundException("no se pudo encontrar el archivo" + nombreArchivo);
                
    
            }
    
    
        } catch (MalformedURLException exception) {
            throw new FileNotFoundException("no se pudo encontrar el archivo" + nombreArchivo + exception);
        }
        
    }

    @Override
    public void eliminarArchivo(String nombreArchivo) {
        Path archivo = cargarArchivo(nombreArchivo);

        try {
            FileSystemUtils.deleteRecursively(archivo);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }


}



