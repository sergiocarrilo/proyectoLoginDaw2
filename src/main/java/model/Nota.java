/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Nota {
    
    private Long idAlumno;
    private Long idAsignatura;
    private String alumno;
    private String asignatura;
    private int nota;
    
    public Nota(){
    }
    
    public void setIdAlumno(Long idAlumno){
        this.idAlumno=idAlumno;
    }
    public void setIdAsignatura(Long idAsignatura){
        this.idAsignatura=idAsignatura;
    }
    public void setNota(int nota){
        this.nota=nota;
    }
    public void setAlumno(String alumno){
        this.alumno=alumno;
    }
    public void setAsignatura(String asignatura){
        this.asignatura=asignatura;
    }
    
    public Long getIdAlumno(){
        return idAlumno;
    }
    public Long getIdAsignatura(){
        return idAsignatura;
    }
    public int getNota(){
        return nota;
    }
    public String getAlumno(){
        return alumno;
    }
    public String getAsignatura(){
        return asignatura;
    }
}
