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
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.InformeNotaAsignatura;
import servicios.AsignaturasServicios;
import servicios.InformeNotasAsignaturasServicios;
import utils.Constantes;

/**
 *
 * @author Gato
 */
@WebServlet(name = "InformeNotasAsignaturasServlet", urlPatterns = {"/informeNotasAsignaturasServlet"})
public class InformeNotasAsignaturasServlet extends HttpServlet {

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
            InformeNotasAsignaturasServicios notasAsignaturasServicios = new InformeNotasAsignaturasServicios();
            List<InformeNotaAsignatura> informe = null;
            String action = request.getParameter(Constantes.actionTemplate);
            Map<String, String[]> parametros = request.getParameterMap();
            String messageToUser = null;
            Curso curso = null;
            if (action != null && !action.isEmpty()) {
                switch (action) {
                    case Constantes.VIEW:

                        curso = notasAsignaturasServicios.tratarParametros(parametros);
                        informe = notasAsignaturasServicios.getInformeNotasAsignaturas(curso.getId());

                        break;
                }//fin switch
            }//fin if action
            HashMap paramentrosPlantilla = new HashMap();
            if (messageToUser != null) {
                paramentrosPlantilla.put(Constantes.messageToUser, messageToUser);
            }
            if (informe != null && curso != null) {
                paramentrosPlantilla.put(Constantes.ListadoInformeNotasAsig, informe);
                paramentrosPlantilla.put(Constantes.CursoSeleccionado, curso.getCurso());

            }
            paramentrosPlantilla.put(Constantes.listaCursos, serviciosAsignatura.getAllCursosdbUtils());
            Template plantilla = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.InformeNotasAsignaturas);
            plantilla.process(paramentrosPlantilla, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(InformeNotasAsignaturasServlet.class.getName()).log(Level.SEVERE, null, ex);
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
