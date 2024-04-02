package org.example;

import java.util.Set;

public class Alumno {
    private String nombre;
    private String apellido;
    private String legajo;
    private Set<Materia> materiasAprobadas;
    public Alumno(String nombre, String apellido, String legajo, Set<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materiasAprobadas = materiasAprobadas;
    }
    public Boolean aproboMateria(Materia materia) {
        return materiasAprobadas.contains(materia);
    }
}
