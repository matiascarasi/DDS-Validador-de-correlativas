package org.example;

import java.util.Set;
import java.util.stream.Collectors;

public class Inscripcion {
    private Set<Materia> materias;
    private Alumno alumno;
    public Inscripcion(Set<Materia> materias, Alumno alumno) {
        this.materias = materias;
        this.alumno = alumno;
    }
    public Boolean aprobada() {
        Set<Materia> correlativas = materias
                .stream()
                .flatMap(x->x.getCorrelativas().stream())
                .collect(Collectors.toSet());
        for(Materia correlativa : correlativas) {
            if(!alumno.aproboMateria(correlativa)) return false;
        }
        return true;
    }
}
