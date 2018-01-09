/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.TareasDAO;
import java.util.List;
import java.util.Map;
import model.TareaAlumno;
import utils.Constantes;

/**
 *
 * @author Gato
 */
public class TareasServicios {

    public TareasServicios() {
    }

    public List<TareaAlumno> getAllTareasOfAlumno(long id_alumno) {
        TareasDAO dao = new TareasDAO();
        return dao.getTareasByIdAlumnodbUtils(id_alumno);
    }

    public boolean updateTareaAlumno(TareaAlumno tarea) {
        TareasDAO dao = new TareasDAO();
        return dao.updateTareaAlumnoJdbcTemplate(tarea) > 0;
    }

    public TareaAlumno tratarParametrosTareaAlumno(Map<String, String[]> parametros) {
        TareaAlumno tarea = new TareaAlumno();
        if (parametros != null && !parametros.isEmpty()) {

            if (parametros.get(Constantes.ID_TAREAS_ALUMNO) != null && !parametros.get(Constantes.ID_TAREAS_ALUMNO)[0].isEmpty()) {
                tarea.setId_tareas_alumnos(Long.valueOf(parametros.get(Constantes.ID_TAREAS_ALUMNO)[0]));
            }
            if (parametros.get(Constantes.HECHO) != null && !parametros.get(Constantes.HECHO)[0].isEmpty()) {
                tarea.setHecho("1".equals(parametros.get(Constantes.HECHO)[0]) ? Boolean.TRUE : Boolean.FALSE);
            } else {
                tarea = null;
            }

        }
        return tarea;
    }

}//fin clase
