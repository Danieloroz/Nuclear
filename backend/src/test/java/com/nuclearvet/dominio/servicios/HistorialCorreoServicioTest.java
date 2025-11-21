package com.nuclearvet.dominio.servicios;

import com.nuclearvet.aplicacion.mapeadores.HistorialCorreoMapeador;
import com.nuclearvet.dominio.enumeraciones.EstadoCorreo;
import com.nuclearvet.infraestructura.persistencia.HistorialCorreoRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HistorialCorreoServicioTest {

    @Mock
    private HistorialCorreoRepositorio historialCorreoRepositorio;

    @Mock
    private HistorialCorreoMapeador historialCorreoMapeador;

    @InjectMocks
    private HistorialCorreoServicio historialCorreoServicio;

    @Test
    void deberiaListarTodosInvocandoRepositorio() {
        when(historialCorreoRepositorio.findAll()).thenReturn(Arrays.asList());
        historialCorreoServicio.listarTodos();
        verify(historialCorreoRepositorio, times(1)).findAll();
    }

    @Test
    void deberiaListarPorDestinatarioInvocandoRepositorio() {
        String email = "test@test.com";
        when(historialCorreoRepositorio.findByDestinatarioConPlantilla(email)).thenReturn(Arrays.asList());
        historialCorreoServicio.listarPorDestinatario(email);
        verify(historialCorreoRepositorio, times(1)).findByDestinatarioConPlantilla(email);
    }

    @Test
    void deberiaListarPorEstadoInvocandoRepositorio() {
        EstadoCorreo estado = EstadoCorreo.ENVIADO;
        when(historialCorreoRepositorio.findByEstado(estado)).thenReturn(Arrays.asList());
        historialCorreoServicio.listarPorEstado(estado);
        verify(historialCorreoRepositorio, times(1)).findByEstado(estado);
    }

    @Test
    void deberiaListarPendientesInvocandoRepositorio() {
        when(historialCorreoRepositorio.findPendientesDeEnvio()).thenReturn(Arrays.asList());
        historialCorreoServicio.listarPendientes();
        verify(historialCorreoRepositorio, times(1)).findPendientesDeEnvio();
    }

    @Test
    void deberiaListarConErrorInvocandoRepositorio() {
        when(historialCorreoRepositorio.findConError()).thenReturn(Arrays.asList());
        historialCorreoServicio.listarConError();
        verify(historialCorreoRepositorio, times(1)).findConError();
    }
}
