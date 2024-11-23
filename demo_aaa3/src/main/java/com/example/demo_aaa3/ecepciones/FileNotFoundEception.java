package com.example.demo_aaa3.ecepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FileNotFoundEception extends RuntimeException{

    private static final long serialVersionUID = 1;

    public FileNotFoundEception(String mensaje ) {
        super(mensaje);
    }

    public FileNotFoundEception(String mensaje, Throwable exception ) {
        super(mensaje, exception);
    }
    
}
