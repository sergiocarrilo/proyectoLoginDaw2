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
public class ProfesorAsignatura {

    private long id;
    private long id_profe;
    private long id_asignatura;
    private String nombre_profe;
    private String nombre_asignatura;

    public ProfesorAsignatura() {
    }

    public ProfesorAsignatura(long id, long id_profe, long id_asignatura, String nombre_profe, String nombre_asignatura) {
        this.id = id;
        this.id_profe = id_profe;
        this.id_asignatura = id_asignatura;
        this.nombre_profe = nombre_profe;
        this.nombre_asignatura = nombre_asignatura;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_profe() {
        return id_profe;
    }

    public void setId_profe(long id_profe) {
        this.id_profe = id_profe;
    }

    public long getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(long id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNombre_profe() {
        return nombre_profe;
    }

    public void setNombre_profe(String nombre_profe) {
        this.nombre_profe = nombre_profe;
    }

    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }

}
