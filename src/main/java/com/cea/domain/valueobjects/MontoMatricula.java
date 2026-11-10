package com.cea.domain.valueobjects;

import com.cea.domain.exceptions.ExcepcionDeDominio;
import java.util.Objects;

public final class MontoMatricula {
    private final double valor;
    private final String moneda;

    public MontoMatricula(double valor, String moneda) {
        if (valor < 0) {
            throw new ExcepcionDeDominio("El monto de la matrícula no puede ser un valor negativo.");
        }
        if (moneda == null || moneda.isBlank()) {
            throw new ExcepcionDeDominio("La moneda es obligatoria (ej. COP).");
        }
        this.valor = valor;
        this.moneda = moneda.trim().toUpperCase();
    }

    public double getValor() {
        return valor;
    }

    public String getMoneda() {
        return moneda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MontoMatricula that = (MontoMatricula) o;
        return Double.compare(that.valor, valor) == 0 && moneda.equals(that.moneda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, moneda);
    }
}