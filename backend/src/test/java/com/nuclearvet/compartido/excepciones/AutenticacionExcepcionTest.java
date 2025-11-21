package com.nuclearvet.compartido.excepciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutenticacionExcepcionTest {

    @Test
    void mensajeSePropaga() {
        String msg = "Credenciales inválidas";
        AutenticacionExcepcion ex = new AutenticacionExcepcion(msg);
        assertEquals(msg, ex.getMessage());
    }
}
