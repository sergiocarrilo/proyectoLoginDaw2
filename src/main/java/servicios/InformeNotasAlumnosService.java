/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import model.Asignatura;
import dao.InformeNotaAlumnoDAO;
import java.sql.Date;
import java.util.Iterator;
import java.util.Map;
import model.Administrador;
import model.InformeNotasAlumnos;
import utils.Constantes;
/**
 *
 * @author DAW
 */
public class InformeNotasAlumnosService {

    public List<InformeNotasAlumnos> getAsignaturasProfe(long id) {
       InformeNotaAlumnoDAO dao = new InformeNotaAlumnoDAO();
       return dao.getAsigntaruasProfe(id);
    }
    
    public InformeNotasAlumnos recogerParametros(Map<String, String[]> parametros) {
        InformeNotasAlumnos informe = null;
        if (parametros != null && !parametros.isEmpty()) {

            informe  = new InformeNotasAlumnos();

            Iterator<String> it = parametros.keySet().iterator();
            
            while (it.hasNext()) {
                String key = (String) it.next();
                String[] values = (String[]) parametros.get(key);
                if (values[0] != null && !values[0].isEmpty()) {
                    if (Constantes.IDASIGNATURA.equalsIgnoreCase(key)) {
                        informe.setId_asignatura(Long.valueOf(values[0]));
                    }else  if (Constantes.ASIGNATURA.equalsIgnoreCase(key)) {
                        informe.setNombre_asignatura(String.valueOf(values[0]));
                    }
                }
            }
        
        }
        return informe;
    }

    public List<InformeNotasAlumnos> getNotasAsignatura(long id_asignatura) {
        InformeNotaAlumnoDAO dao = new InformeNotaAlumnoDAO();
        return  dao.getNotasAsignatura(id_asignatura);
    }

   

    
}

