/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import config.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Asignatura;

import model.AsignaturaCurso;
import model.Curso;
import servicios.AsignaturasServicios;
import utils.Constantes;
import utils.ConstantesError;
import utils.UrlsPaths;

/**
 *
 * @author daw
 */
@WebServlet(name = "AsignaturasServlet", urlPatterns = {UrlsPaths.ASIGNATURAS})
public class AsignaturasServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, TemplateException {
        //request.setCharacterEncoding("UTF-8");
        AsignaturasServicios servicios = new AsignaturasServicios();

        String action = request.getParameter(Constantes.actionTemplate);
        String messageToUser = null;
        AsignaturaCurso asignaturaCurso = null;
        HashMap paramentrosPlantilla = null;
        Map<String, String[]> parametros = request.getParameterMap();
        if (action != null && !action.isEmpty()) {

            switch (action) {
                case Constantes.UPDATE:

                    asignaturaCurso = servicios.tratarParametros(parametros);
                    int filas = servicios.updateAsignaturaCursodbUtils(asignaturaCurso);
                    messageToUser = (filas > 0) ? Constantes.messageQueryAsignaturaUpdated : Constantes.messageQueryAsignaturaUpdateFailed;

                    break;
                case Constantes.UPDATE_ASIGNATURA:

                    asignaturaCurso = servicios.tratarParametros(parametros);
                    Asignatura asignatura = servicios.toAsignatura(asignaturaCurso);
                    int filasAs = servicios.updateAsignaturadbUtils(asignatura);

                    messageToUser = (filasAs > 0) ? Constantes.messageQueryAsignaturaUpdated : Constantes.messageQueryAsignaturaUpdateFailed;

                    break;
                case Constantes.UPDATE_CURSO:

                    asignaturaCurso = servicios.tratarParametros(parametros);
                    Curso cursoUp = servicios.toCurso(asignaturaCurso);
                    int filasUp = servicios.updateCursodbUtils(cursoUp);

                    messageToUser = (filasUp > 0) ? Constantes.messageQueryAsignaturaUpdated : Constantes.messageQueryAsignaturaUpdateFailed;

                    break;
                case Constantes.INSERT:

                    asignaturaCurso = servicios.tratarParametros(parametros);
                    messageToUser = (servicios.insertAsignaturaCursodbUtils(asignaturaCurso))
                            ? Constantes.messageQueryAsignaturaInserted : Constantes.messageQueryAsignaturaInsertFailed;

                    break;
                case Constantes.INSERT_ASIGNATURA:
//
//                    asignaturaCurso = servicios.tratarParametros(parametros);
//                    Asignatura asignaturaIn = servicios.toAsignatura(asignaturaCurso);
//                    messageToUser = (servicios.insertAsignaturadbUtils(asignaturaIn))
//                            ? Constantes.messageQueryAsignaturaInserted : Constantes.messageQueryAsignaturaInsertFailed;

                    break;
                case Constantes.INSERT_CURSO:

                    asignaturaCurso = servicios.tratarParametros(parametros);
                    Curso curso = servicios.toCurso(asignaturaCurso);
                    messageToUser = (servicios.insertCursodbUtils(curso))
                            ? Constantes.messageQueryAsignaturaInserted : Constantes.messageQueryAsignaturaInsertFailed;

                    break;
                case Constantes.DELETE:
                    String id_asignatura = request.getParameter(Constantes.ID_ASIGNATURA.toLowerCase());
                    String id_curso = request.getParameter(Constantes.ID_CURSO.toLowerCase());
                    int deleted = -1;
                    if (id_asignatura != null && !id_asignatura.isEmpty() && id_curso != null && !id_curso.isEmpty()) {
                        deleted = servicios.deleteAsignaturaCursodbUtils(id_asignatura, id_curso);

                    }
                    if (deleted == ConstantesError.CodeErrorClaveForanea) {

                        asignaturaCurso = servicios.tratarParametros(parametros);

                        messageToUser = Constantes.messageQueryAsignaturaDeletedFail;

                    } else if (deleted > 0 && deleted < ConstantesError.CodeErrorClaveForanea) {
                        messageToUser = Constantes.messageQueryAsignaturaDeleted;
                    }
                    break;
                case Constantes.DELETE_ASIGNATURA:

                    String IdAs = request.getParameter(Constantes.ID_ASIGNATURA.toLowerCase());
                    int deletedAs = -1;
                    if (IdAs != null && !IdAs.isEmpty()) {
                        deletedAs = servicios.deleteAsignaturadbUtils(IdAs);

                    }
                    if (deletedAs == ConstantesError.CodeErrorClaveForanea) {

                        asignaturaCurso = servicios.tratarParametros(parametros);

                        messageToUser = Constantes.messageQueryAsignaturaDeletedFail;

                    } else if (deletedAs > 0 && deletedAs < ConstantesError.CodeErrorClaveForanea) {
                        messageToUser = Constantes.messageQueryAsignaturaDeleted;
                    }
                    break;
                case Constantes.DELETE_CURSO:

                    String IdCu = request.getParameter(Constantes.ID_CURSO.toLowerCase());
                    int deletedCu = -1;
                    if (IdCu != null && !IdCu.isEmpty()) {
                        deletedCu = servicios.deleteCursodbUtils(IdCu);

                    }
                    if (deletedCu == ConstantesError.CodeErrorClaveForanea) {

                        asignaturaCurso = servicios.tratarParametros(parametros);

                        messageToUser = Constantes.messageQueryAsignaturaDeletedFail;

                    } else if (deletedCu > 0 && deletedCu < ConstantesError.CodeErrorClaveForanea) {
                        messageToUser = Constantes.messageQueryAsignaturaDeleted;
                    }
                    break;

            }
        }
        paramentrosPlantilla = new HashMap();
        if (messageToUser != null) {
            paramentrosPlantilla.put(Constantes.messageToUser, messageToUser);
        }

        paramentrosPlantilla.put(Constantes.listaAsignaturaCurso, servicios.getAllAsignaturasCursosdbUtils());
        paramentrosPlantilla.put(Constantes.listaCursos, servicios.getAllCursosdbUtils());
        paramentrosPlantilla.put(Constantes.listaAsignaturas, servicios.getAllAsignaturadbUtils());
        Template plantilla = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.asignaturasTemplate);
        plantilla.process(paramentrosPlantilla, response.getWriter());

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (TemplateException ex) {
            Logger.getLogger(AsignaturasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (TemplateException ex) {
            Logger.getLogger(AsignaturasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
