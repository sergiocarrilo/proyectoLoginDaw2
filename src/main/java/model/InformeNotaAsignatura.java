/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Gato
 */
public class InformeNotaAsignatura {

    private List<Profesor> profesores;
    private String asignatura;
    private List<InformeNota> notas;
    
    public InformeNotaAsignatura() {
    }

    public InformeNotaAsignatura(List<Profesor> profesores, String asignatura, List<InformeNota> notas) {
        this.profesores = profesores;
        this.asignatura = asignatura;
        this.notas = notas;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public List<InformeNota> getNotas() {
        return notas;
    }

    public void setNotas(List<InformeNota> notas) {
        this.notas = notas;
    }
    
    
    
    
}
