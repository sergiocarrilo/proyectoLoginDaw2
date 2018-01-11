/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.TareasProfesorDAO;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import model.TareasProfesor;
import utils.Constantes;

/**
 *
 * @author DAW
 */
public class TareasProfesorService {
    public TareasProfesor recogerParametros(Map<String, String[]> parametros) {
        TareasProfesor tarea = null;
        if (parametros != null && !parametros.isEmpty()) {

            tarea  = new TareasProfesor();

            Iterator<String> it = parametros.keySet().iterator();
            
            while (it.hasNext()) {
                String key = (String) it.next();
                String[] values = (String[]) parametros.get(key);
                if (values[0] != null && !values[0].isEmpty()) {
                    if (Constantes.IDASIGNATURA.equalsIgnoreCase(key)) {
                        tarea.setId_asignatura(Long.valueOf(values[0]));
                    }else  if (Constantes.NAME.equalsIgnoreCase(key)) {
                        tarea.setTarea(String.valueOf(values[0]));
                    }else  if (Constantes.FECHA_ENTREGA.equalsIgnoreCase(key)) {
                        tarea.setFecha_entrega(java.sql.Date.valueOf(values[0]));
                    }
                }
            }
        
        }
        return tarea;
    }

    public TareasProfesor insertarTarea(TareasProfesor tareas) {
        TareasProfesorDAO dao = new TareasProfesorDAO();
        return dao.insertarTarea(tareas);
    }
}
