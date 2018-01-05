/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gato
 */
public class InformeNota {

    private long id_alumno;
    private String nombre_alumno;
    private int nota;

    public InformeNota() {
    }

    public InformeNota(long id_alumno, String nombre_alumno, int nota) {
        this.id_alumno = id_alumno;
        this.nombre_alumno = nombre_alumno;
        this.nota = nota;
    }

    public long getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(long id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}
