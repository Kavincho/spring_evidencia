package com.example.demo_aaa3.ecepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AlmacenEception extends RuntimeException{

    private static final long serialVersionUID = 1;

    public AlmacenEception(String mensaje ) {
        super(mensaje);
    }

    public AlmacenEception(String mensaje, Throwable exception ) {
        super(mensaje, exception);
    }
    
}
