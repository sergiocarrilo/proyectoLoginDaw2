/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.ProfesorAsignaturaDAO;
import java.util.List;
import java.util.Map;
import model.ProfesorAsignatura;
import utils.Constantes;

/**
 *
 * @author Gato
 */
public class ProfesorAsignaturaServicios {

    public ProfesorAsignaturaServicios() {
    }

    public List<ProfesorAsignatura> getAllProfesoresAsignaturas(long offset) {
        ProfesorAsignaturaDAO dao = new ProfesorAsignaturaDAO();
        return dao.getAllProfesorAsignaturadbUtils(offset);
    }

    public boolean insertProfesorAsignatura(ProfesorAsignatura profesorAsignatura) {
        ProfesorAsignaturaDAO dao = new ProfesorAsignaturaDAO();
        return dao.insertProfesorAsignaturadbUtils(profesorAsignatura);
    }

    public boolean deleteProfesorAsignaturas(ProfesorAsignatura profesorAsignatura) {
        ProfesorAsignaturaDAO dao = new ProfesorAsignaturaDAO();
        return dao.deleteProfesorAsignaturaTemplate(profesorAsignatura) > 0;
    }

    public ProfesorAsignatura tratarParametro(Map<String, String[]> parametros) {
        ProfesorAsignatura profesorAsignatura = null;
        if (parametros != null && !parametros.isEmpty()) {
            profesorAsignatura = new ProfesorAsignatura();
            if (parametros.get(Constantes.ID.toLowerCase()) != null && !parametros.get(Constantes.ID.toLowerCase())[0].isEmpty()) {
                profesorAsignatura.setId(Long.valueOf(parametros.get(Constantes.ID.toLowerCase())[0]));
            }
            if (parametros.get(Constantes.ID_PROFESOR) != null && !parametros.get(Constantes.ID_PROFESOR)[0].isEmpty()) {
                profesorAsignatura.setId_profe(Long.valueOf(parametros.get(Constantes.ID_PROFESOR)[0]));
            } else {
                profesorAsignatura.setId_profe(-1);
            }
            if (parametros.get(Constantes.ID_ASIGNATURA.toLowerCase()) != null && !parametros.get(Constantes.ID_ASIGNATURA.toLowerCase())[0].isEmpty()) {
                profesorAsignatura.setId_asignatura(Long.valueOf(parametros.get(Constantes.ID_ASIGNATURA.toLowerCase())[0]));
            } else {
                profesorAsignatura.setId_asignatura(-1);
            }

        }
        return profesorAsignatura;

    }

    public ProfesorAsignatura getDuplicateRelacion(ProfesorAsignatura relacion) {
        ProfesorAsignaturaDAO dao = new ProfesorAsignaturaDAO();

        return (relacion.getId_asignatura() != -1 && relacion.getId_profe() != -1) ? dao.getDuplicateRelacionProfeAsignaturaJDBCTemplate(relacion) : null;
    }

    public boolean thisRelacionExist(ProfesorAsignatura relaciom) {

        return getDuplicateRelacion(relaciom) != null;
    }

}//fin clase
