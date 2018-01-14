/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author IvanGarGal
 */
public class AlumnoAsignatura {
    private long id;
    private long id_alumno;
    private long id_asignatura;
    private String nombre_alumno;
    private String nombre_asignatura;

    public AlumnoAsignatura() {
    }

    public AlumnoAsignatura(long id, long id_alumno, long id_asignatura, String nombre_alumno, String nombre_asignatura) {
        this.id = id;
        this.id_alumno = id_alumno;
        this.id_asignatura = id_asignatura;
        this.nombre_alumno = nombre_alumno;
        this.nombre_asignatura = nombre_asignatura;
    }

    public AlumnoAsignatura(long id, long id_alumno, long id_asignatura) {
        this.id = id;
        this.id_alumno = id_alumno;
        this.id_asignatura = id_asignatura;
    }
 

    public long getIdAlumnoAsignatura() {
        return id;
    }

    public void setIdAlumnoAsignatura(long id) {
        this.id = id;
    }

    public long getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(long id_alumno) {
        this.id_alumno = id_alumno;
    }

    public long getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(long id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }
}
