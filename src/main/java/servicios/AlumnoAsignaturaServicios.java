/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnoAsignaturaDAO;
import java.util.List;
import java.util.Map;
import model.AlumnoAsignatura;
import utils.Constantes;

/**
 *
 * @author IvanGarGal
 */
public class AlumnoAsignaturaServicios {

    public AlumnoAsignaturaServicios() {
    }

    public List<AlumnoAsignatura> getAllAlumnosAsignaturas(long offset) {
        AlumnoAsignaturaDAO dao = new AlumnoAsignaturaDAO();
        return dao.getAllAlumnoAsignaturadbUtils(offset);
    }

    public boolean insertAlumnoAsignatura(AlumnoAsignatura alumnoAsignatura) {
        AlumnoAsignaturaDAO dao = new AlumnoAsignaturaDAO();
        return dao.insertAlumnoAsignaturadbUtils(alumnoAsignatura);
    }

    public boolean deleteAlumnoAsignaturas(AlumnoAsignatura alumnoAsignatura) {
        AlumnoAsignaturaDAO dao = new AlumnoAsignaturaDAO();
        return dao.deleteAlumnoAsignaturaTemplate(alumnoAsignatura) > 0;
    }

    public AlumnoAsignatura tratarParametro(Map<String, String[]> parametros) {
        AlumnoAsignatura alumnoAsignatura = null;
        if (parametros != null && !parametros.isEmpty()) {
            alumnoAsignatura = new AlumnoAsignatura();
            if (parametros.get(Constantes.ID.toLowerCase()) != null && !parametros.get(Constantes.ID.toLowerCase())[0].isEmpty()) {
                alumnoAsignatura.setIdAlumnoAsignatura(Long.valueOf(parametros.get(Constantes.ID.toLowerCase())[0]));
            }
            if (parametros.get(Constantes.ID_ALUMNO) != null && !parametros.get(Constantes.ID_ALUMNO)[0].isEmpty()) {
                alumnoAsignatura.setId_alumno(Long.valueOf(parametros.get(Constantes.ID_ALUMNO)[0]));
            } else {
                alumnoAsignatura.setId_alumno(-1);
            }
            if (parametros.get(Constantes.ID_ASIGNATURA.toLowerCase()) != null && !parametros.get(Constantes.ID_ASIGNATURA.toLowerCase())[0].isEmpty()) {
                alumnoAsignatura.setId_asignatura(Long.valueOf(parametros.get(Constantes.ID_ASIGNATURA.toLowerCase())[0]));
            } else {
                alumnoAsignatura.setId_asignatura(-1);
            }

        }
        return alumnoAsignatura;

    }

    public AlumnoAsignatura getDuplicateRelacion(AlumnoAsignatura relacion) {
        AlumnoAsignaturaDAO dao = new AlumnoAsignaturaDAO();

        return (relacion.getId_asignatura() != -1 && relacion.getId_alumno() != -1) ? dao.getDuplicateRelacionAlumnoAsignaturaJDBCTemplate(relacion) : null;
    }

    public boolean thisRelacionExist(AlumnoAsignatura relaciom) {

        return getDuplicateRelacion(relaciom) != null;
    }

}//fin clase
