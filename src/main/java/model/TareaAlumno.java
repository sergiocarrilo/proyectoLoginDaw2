/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Gato
 */
public class TareaAlumno {

    private long id_asignatura;
    private long id_tarea;
    private String nombre;
    private String tarea;
    private Date fecha_entrega;
    private boolean hecho;

    public TareaAlumno() {
    }

    public TareaAlumno(long id_asignatura, long id_tarea, String nombre, String tarea, Date fecha_entrega, boolean hecho) {
        this.id_asignatura = id_asignatura;
        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.tarea = tarea;
        this.fecha_entrega = fecha_entrega;
        this.hecho = hecho;
    }

    public long getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(long id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(long id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public boolean isHecho() {
        return hecho;
    }

    public void setHecho(boolean hecho) {
        this.hecho = hecho;
    }

}
