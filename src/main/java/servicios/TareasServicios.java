/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.TareasDAO;
import java.util.List;
import model.TareaAlumno;

/**
 *
 * @author Gato
 */
public class TareasServicios {

    public TareasServicios() {
    }
    public List<TareaAlumno> getAllTareasOfAlumno(long id_alumno ) {
        TareasDAO dao = new TareasDAO();
        return dao.getTareasByIdAlumnodbUtils(id_alumno);
    }
    
    
}//fin clase
