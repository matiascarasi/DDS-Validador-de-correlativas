package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    Alumno santos;
    Alumno lamponne;
    Alumno ravenna;
    Alumno medina;
    Materia pdp;
    Materia ayed;
    Materia am1;
    Materia am2;
    @BeforeEach
    public void setUp() throws Exception {
        // Materias
        ayed = new Materia("Algoritmos y Estructuras de Datos", new HashSet<>());
        am1 = new Materia("Análisis Matemático 1", new HashSet<>());
        pdp = new Materia("Paradigmas de Programación", new HashSet<>(Arrays.asList(ayed, am1)));
        am2 = new Materia("Análisis Matemático 2", new HashSet<>(Collections.singletonList(am1)));
        // Alumnos
        santos = new Alumno("Mario", "Santos", "1231231", new HashSet<>(Arrays.asList(ayed, am1)));
        lamponne = new Alumno("Pablo", "Lamponne", "1231232", new HashSet<>(Collections.singletonList(am1)));
        ravenna = new Alumno("Emilio", "Ravenna", "1231233", new HashSet<>());
        medina = new Alumno("Gabriel David", "Medina", "1231234", new HashSet<>(Collections.singletonList(am1)));
    }
    @Test
    public void aprobada() {
        Inscripcion inscripcionSantos = new Inscripcion(new HashSet<>(Collections.singletonList(pdp)), santos);
        Inscripcion inscripcionLamponne = new Inscripcion(new HashSet<>(Collections.singletonList(pdp)), lamponne);
        Inscripcion inscripcionRavenna = new Inscripcion(new HashSet<>(Collections.singletonList(am1)), ravenna);
        Inscripcion inscripcionMedina = new Inscripcion(new HashSet<>(Arrays.asList(am2, pdp)), medina);
        assertAll(
                ()->assertTrue(inscripcionSantos.aprobada(), "Si cumple todas las correlativas de una materia, la inscripción se aprueba"),
                ()->assertFalse(inscripcionLamponne.aprobada(), "Si no cumple todas las correlativas de una materia, la inscripción se desaprueba"),
                ()->assertTrue(inscripcionRavenna.aprobada(), "Si la materia no tiene correlativas, la inscripción se aprueba"),
                ()->assertFalse(inscripcionMedina.aprobada(), "Si no cumple todas las correlativas para más de una materia, la inscripción se desaprueba")
        );
    }
}