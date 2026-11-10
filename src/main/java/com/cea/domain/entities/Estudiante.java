package com.cea.domain.entities;

import com.cea.domain.exceptions.ExcepcionDeDominio;
import com.cea.domain.valueobjects.CorreoInstitucional;

public class Estudiante {
    private final String estudianteId;
    private String nombre;
    private CorreoInstitucional correo;

    public Estudiante(String estudianteId, String nombre, CorreoInstitucional correo) {
        if (estudianteId == null || estudianteId.trim().isEmpty()) {
            throw new ExcepcionDeDominio("El ID del estudiante no puede estar vacío.");
        }
        this.estudianteId = estudianteId;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getEstudianteId() {
        return estudianteId;
    }

    public String getNombre() {
        return nombre;
    }

    public CorreoInstitucional getCorreo() {
        return correo;
    }
}