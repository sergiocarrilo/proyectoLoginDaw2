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
import java.util.ArrayList;
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
import servicios.AsignaturasServicios;
import utils.Constantes;
import utils.ConstantesError;
import utils.SqlQuery;
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
        request.setCharacterEncoding("UTF-8");
        AsignaturasServicios servicios = new AsignaturasServicios();

        String action = request.getParameter(Constantes.actionJSP);
        String messageToUser = null;
        Asignatura asignatura = null;
        HashMap paramentrosPlantilla = null;
        Map<String, String[]> parametros = request.getParameterMap();
        if (action != null && !action.isEmpty()) {

            switch (action) {
                case Constantes.UPDATE:
                    
                    asignatura = servicios.tratarParametros(parametros);
                    int filas = servicios.updateAsignaturadbUtils(asignatura);

                    messageToUser = (filas > 0) ? Constantes.messageQueryAsignaturaUpdated : Constantes.messageQueryAsignaturaUpdateFailed;

                    break;
                case Constantes.INSERT:

                    asignatura = servicios.tratarParametros(parametros);

                    messageToUser = (servicios.insertAsignaturadbUtils(asignatura))
                            ? Constantes.messageQueryAsignaturaInserted : Constantes.messageQueryAsignaturaInsertFailed;

                    break;
                case Constantes.DELETE:
                    String key = request.getParameter(Constantes.ID.toLowerCase());
                    int deleted = -1;
                    if (key != null && !key.isEmpty()) {
                        deleted = servicios.deleteAsignaturadbUtils(key);

                    }
                    if (deleted == ConstantesError.CodeErrorClaveForanea) {

                        asignatura = servicios.tratarParametros(parametros);
                        request.setAttribute(Constantes.asignaturaResult, asignatura);
                        messageToUser = Constantes.messageQueryAsignaturaDeletedFail;

                    } else if (deleted > 0 && deleted < ConstantesError.CodeErrorClaveForanea) {
                        messageToUser = Constantes.messageQueryAsignaturaDeleted;
                    }
                    break;
                case Constantes.DELETE_FORCE:
/*
                    asignatura = servicios.tratarParametros(parametros);

                    try {
                        boolean borrado = servicios.deleteAsignaturaForce((int) asignatura.getId());
                        messageToUser = (borrado) ? Constantes.messageQueryAsignaturaDeleted : Constantes.messageQueryAsignaturaDeletedFailedAgain;

                    } catch (SQLException ex) {
                        Logger.getLogger(AsignaturasServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
*/
                    //1º -> BORRAR NOTA 
                    //2º -> BORRAR ASIGNATURA
                    break;

            }
        }

        if (messageToUser != null) {
            request.setAttribute(Constantes.resultadoQuery, messageToUser);
        }
        paramentrosPlantilla = new HashMap();
        paramentrosPlantilla.put(Constantes.listaAsignaturas, servicios.getAllAsignaturasdbUtils());
        Template plantilla = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.asignaturasTemplate);
        plantilla.process(paramentrosPlantilla, response.getWriter());
        
        request.setAttribute(Constantes.asignaturasList, servicios.getAllAsignaturasdbUtils());//envia la lista al jsp
        request.getRequestDispatcher("/" + Constantes.asignaturasTemplate).forward(request, response);
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
