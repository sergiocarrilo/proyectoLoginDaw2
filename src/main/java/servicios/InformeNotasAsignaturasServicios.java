/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturasDAO;
import dao.InformeNotasAsignaturasDAO;
import dao.ProfesoresDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Asignatura;
import model.Curso;
import model.InformeNotaAsignatura;
import model.Profesor;
import utils.Constantes;

/**
 *
 * @author Gato
 */
public class InformeNotasAsignaturasServicios {

    public InformeNotasAsignaturasServicios() {
    }

    public Curso tratarParametros(Map<String, String[]> parametros) {
        Curso curso = new Curso();
        if (parametros != null && !parametros.isEmpty()) {

            if (parametros.get(Constantes.ID_CURSO.toLowerCase()) != null && !parametros.get(Constantes.ID_CURSO.toLowerCase())[0].isEmpty()) {
                curso.setId(Long.valueOf(parametros.get(Constantes.ID_CURSO.toLowerCase())[0]));
            }
            if (parametros.get(Constantes.CURSO.toLowerCase()) != null && !parametros.get(Constantes.CURSO.toLowerCase())[0].isEmpty()) {
                curso.setCurso(parametros.get(Constantes.CURSO.toLowerCase())[0]);
            }

        }
        return curso;
    }

    public List<InformeNotaAsignatura> getInformeNotasAsignaturas(long id_curso) {

        List<InformeNotaAsignatura> informe = null;
        InformeNotaAsignatura informeNotaAsignatura = null;

        List<Asignatura> asignaturas = getAsignaturasByIdCurso(id_curso);
        if (asignaturas != null && !asignaturas.isEmpty()) {
            informe = new ArrayList<>();
            for (Asignatura asig : asignaturas) {
                informeNotaAsignatura = new InformeNotaAsignatura();
                informeNotaAsignatura.setAsignatura(asig.getNombre());

                List<Profesor> profesores = getProfesoresByIdCursoAndIdAsignatura(id_curso, asig.getId());
                informeNotaAsignatura.setProfesores(profesores);

                InformeNotasAsignaturasDAO notasAsignaturasDAO = new InformeNotasAsignaturasDAO();

                informeNotaAsignatura.setNotas(notasAsignaturasDAO.getNotasByIdCursoAndIdAsignaturadbUtils(id_curso, asig.getId()));

                informe.add(informeNotaAsignatura);

            }//fin for each

        }//fin if asig !null

        return informe;
    }

    private List<Asignatura> getAsignaturasByIdCurso(long id_curso) {
        AsignaturasDAO asignaturasDAO = new AsignaturasDAO();

        return asignaturasDAO.getAsignaturasByIdCursodbUtils(id_curso);

    }

    private List<Profesor> getProfesoresByIdCursoAndIdAsignatura(long id_curso, long id_asignatura) {

        ProfesoresDAO dao = new ProfesoresDAO();

        return dao.getProfesoresByIdCursoAndIdAsignaturadbUtils(id_curso, id_asignatura);

    }

}//fin clase
