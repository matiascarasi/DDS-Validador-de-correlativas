package org.example;

import java.util.Set;

public class Materia {
    private String nombre;
    private Set<Materia> correlativas;
    public Materia(String nombre, Set<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }
    public Set<Materia> getCorrelativas() {
        return correlativas;
    }
}
