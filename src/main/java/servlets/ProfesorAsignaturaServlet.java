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
import model.ProfesorAsignatura;
import servicios.AsignaturasServicios;
import servicios.ProfesorAsignaturaServicios;
import servicios.ProfesorServicios;
import utils.Constantes;
import utils.UrlsPaths;

/**
 *
 * @author Gato
 */
@WebServlet(name = "ProfesorAsignaturaServlet", urlPatterns = {UrlsPaths.PROFESOR_ASIGNATURAS})
public class ProfesorAsignaturaServlet extends HttpServlet {

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
            throws ServletException, IOException {
        try {
            AsignaturasServicios serviciosAsignatura = new AsignaturasServicios();
            ProfesorServicios serviciosProfesor = new ProfesorServicios();
            ProfesorAsignaturaServicios serviciosPA = new ProfesorAsignaturaServicios();
            String action = request.getParameter(Constantes.actionTemplate);
            String messageToUser = null;
            ProfesorAsignatura profesorAsignatura = null;
            HashMap paramentrosPlantilla = null;
            Map<String, String[]> parametros = request.getParameterMap();
            if (action != null && !action.isEmpty()) {

                switch (action) {
                    case Constantes.INSERT:
                        profesorAsignatura = serviciosPA.tratarParametro(parametros);
                        messageToUser = (serviciosPA.insertProfesorAsignatura(profesorAsignatura))
                                ? Constantes.messageQueryProfeAsignaturaInserted : Constantes.messageQueryProfeAsignaturaInsertFailed;
                        ;

                        break;
                    case Constantes.DELETE:
                        profesorAsignatura = serviciosPA.tratarParametro(parametros);
                        messageToUser = (serviciosPA.deleteProfesorAsignaturas(profesorAsignatura))
                                ? Constantes.messageQueryProfesorAsignaturaDeleted : Constantes.messageQueryProfesorAsignaturaDeletedFail;

                        break;

                }//fin switch
            }//fin if action

            paramentrosPlantilla = new HashMap();
            if (messageToUser != null) {
                paramentrosPlantilla.put(Constantes.messageToUser, messageToUser);
            }

            paramentrosPlantilla.put(Constantes.listaProfesoresAsignaturas, serviciosPA.getAllProfesoresAsignaturas());
            paramentrosPlantilla.put(Constantes.listaProfesores, serviciosProfesor.getAllProfesores());
            paramentrosPlantilla.put(Constantes.listaAsignaturas, serviciosAsignatura.getAllAsignaturadbUtils());
            Template plantilla = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.ProfesorAsignaturaTemplate);
            plantilla.process(paramentrosPlantilla, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(ProfesorAsignaturaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//fin processRequest

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
        processRequest(request, response);
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
        processRequest(request, response);
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