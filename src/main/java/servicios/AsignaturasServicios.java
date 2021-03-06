/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturasDAO;
import java.io.UnsupportedEncodingException;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import model.Asignatura;

import model.AsignaturaCurso;
import model.Curso;
import model.ProfesorAsignatura;
import utils.Constantes;

/**
 *
 * @author daw
 */
public class AsignaturasServicios {

    public List<AsignaturaCurso> getAllAsignaturasCursosdbUtils(long offset) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.getAllAsignaturasCursosdbUtils(offset);
    }

    public List<Curso> getAllCursosdbUtils() {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.getAllCursosdbUtils();
    }

    public List<Asignatura> getAllAsignaturadbUtils() {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.getAllAsignaturasdbUtils();
    }

    public boolean insertAsignaturaCursodbUtils(AsignaturaCurso a) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.insertAsignaturaCursodbUtils(a);
    }

    public boolean insertAsignaturadbUtils(Asignatura a) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.insertAsignaturadbUtils(a);
    }

    public boolean insertCursodbUtils(Curso c) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.insertCursodbUtils(c);
    }

    public int updateAsignaturaCursodbUtils(AsignaturaCurso asignaturaCurso) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.updateAsignaturasCursoJdbcTemplate(asignaturaCurso);

    }

    public int updateAsignaturadbUtils(Asignatura asignatura) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.updateAsignaturasdbUtils(asignatura);
    }

    public int updateCursodbUtils(Curso cursoUp) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.updateCursodbUtils(cursoUp);
    }

    public int deleteAsignaturaCursodbUtils(String id_asignatura, String id_curso) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.deleteAsignaturaCursodbUtils(id_asignatura, id_curso);
    }

    public int deleteAsignaturadbUtils(String key) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.deleteAsignaturadbUtils(key);
    }

    public int deleteCursodbUtils(String key) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.deleteCursodbUtils(key);
    }
   

    public AsignaturaCurso tratarParametros(Map<String, String[]> parametros) throws UnsupportedEncodingException {
        AsignaturaCurso asignatura = null;
        if (parametros != null && !parametros.isEmpty()) {

            asignatura = new AsignaturaCurso();

            Iterator<String> it = parametros.keySet().iterator();

            while (it.hasNext()) {
                String key = (String) it.next();
                String[] values = (String[]) parametros.get(key);
                if (values[0] != null && !values[0].isEmpty()) {

                    if (Constantes.ID_ASIGNATURA.equalsIgnoreCase(key) && !values[0].isEmpty()) {
                        asignatura.setId_asignatura(Long.valueOf(values[0]));
                    } else if (Constantes.ID_ASIGNATURA.equalsIgnoreCase(key) && values[0].isEmpty()) {
                        asignatura.setId_asignatura(-1);
                    } else if (Constantes.ID_CURSO.equalsIgnoreCase(key)) {
                        asignatura.setId_curso(Long.valueOf(values[0]));
                    } else if (Constantes.ID_CURSO.equalsIgnoreCase(key) && values[0].isEmpty()) {
                        asignatura.setId_curso(-1);
                    } else if (Constantes.NOMBRE.equalsIgnoreCase(key)) {
                        asignatura.setNombre(values[0]);
                    } else if (Constantes.CURSO.equalsIgnoreCase(key)) {

                        asignatura.setCurso(values[0]);

                    } else if (Constantes.ID.equalsIgnoreCase(key)) {

                        asignatura.setId(Long.valueOf(values[0]));

                    }
                    /*else if (Constantes.CICLO.equalsIgnoreCase(key)) {
                        asignatura.setCiclo(values[0]);

                    }*/
                }

            }

        }
        return asignatura;
    }

    public AsignaturaCurso getDuplicateRelacion(AsignaturaCurso relacion) {
        AsignaturasDAO dao = new AsignaturasDAO();

        return (relacion.getId_asignatura() != -1 && relacion.getId_curso() != -1) ? dao.getDuplicateRelacionAsignaturaCursoJDBCTemplate(relacion) : null;
    }

    public boolean thisRelacionExist(AsignaturaCurso relaciom) {

        return getDuplicateRelacion(relaciom) != null;
    }

    public Asignatura toAsignatura(AsignaturaCurso as) {
        Asignatura asignatura = new Asignatura();
        asignatura.setId(as.getId_asignatura());
        asignatura.setNombre(as.getNombre());
        return asignatura;
    }

    public Curso toCurso(AsignaturaCurso as) {
        Curso curso = new Curso();
        curso.setId(as.getId_curso());
        curso.setCurso(as.getCurso());
        return curso;
    }

    //utilizado en notas 
    public List<AsignaturaCurso> getAllAsignaturasdbUtils() {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.getAllAsignaturasdbUtilsNotas();
    }

    public List<ProfesorAsignatura> getAllAsignaturasByIdProfesor(long id_profesor) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.getAllAsignaturasByIdProfesordbUtils(id_profesor);
    }

}//FIN CLASE
