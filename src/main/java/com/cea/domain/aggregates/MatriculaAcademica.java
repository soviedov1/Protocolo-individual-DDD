package com.cea.domain.aggregates;

import com.cea.domain.exceptions.ExcepcionDeDominio;
import java.util.ArrayList;
import java.util.List;

public class MatriculaAcademica {
    private final String matriculaId;
    private final String estudianteId;
    private final List<String> cursosMatriculados;
    private int creditosTotales;

    public MatriculaAcademica(String matriculaId, String estudianteId) {
        if (matriculaId == null || matriculaId.trim().isEmpty()) {
            throw new ExcepcionDeDominio("El ID de la matrícula es obligatorio.");
        }
        if (estudianteId == null || estudianteId.trim().isEmpty()) {
            throw new ExcepcionDeDominio("El ID del estudiante es obligatorio.");
        }
        this.matriculaId = matriculaId;
        this.estudianteId = estudianteId;
        this.cursosMatriculados = new ArrayList<>();
        this.creditosTotales = 0;
    }

    public void agregarCurso(String codigoCurso, int creditosCurso) {
        if (codigoCurso == null || codigoCurso.trim().isEmpty()) {
            throw new ExcepcionDeDominio("El código del curso no puede estar vacío.");
        }
        if (creditosCurso <= 0) {
            throw new ExcepcionDeDominio("Los créditos del curso deben ser mayores a cero.");
        }
        if (this.creditosTotales + creditosCurso > 20) {
            throw new ExcepcionDeDominio("Se supera el límite máximo de 20 créditos.");
        }
        if (this.cursosMatriculados.contains(codigoCurso)) {
            throw new ExcepcionDeDominio("El curso ya está matriculado.");
        }
        this.cursosMatriculados.add(codigoCurso);
        this.creditosTotales += creditosCurso;
    }

    public int getCreditosTotales() {
        return creditosTotales;
    }

    public List<String> getCursosMatriculados() {
        return cursosMatriculados;
    }
}