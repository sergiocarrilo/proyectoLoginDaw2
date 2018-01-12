/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.InformeAlumnoNotasDAO;
import java.util.List;
import model.Nota;
import model.Alumno;

/**
 *
 * @author IvanGarGal
 */
public class InformeAlumnoNotasServicios {
    public List<Nota> verAlumnos(Long id){
        InformeAlumnoNotasDAO dao = new InformeAlumnoNotasDAO();
        return dao.verAlumnos(id);
    }
    
    public List<Alumno> getAllAlumnos(){
        InformeAlumnoNotasDAO dao = new InformeAlumnoNotasDAO();
        return dao.getAllAlumnos();
    }
    
}
