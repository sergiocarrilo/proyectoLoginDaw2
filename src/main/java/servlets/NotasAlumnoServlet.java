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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import servicios.NotasServicios;
import utils.Constantes;
import utils.LevelAccessUser;
import utils.UrlsPaths;

/**
 *
 * @author daw
 */
@WebServlet(name = "NotasAlumnoServlet", urlPatterns = {UrlsPaths.NOTAS_ALUMNO})
public class NotasAlumnoServlet extends HttpServlet {

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

            NotasServicios servicios = new NotasServicios();
            HashMap paramentrosPlantilla = new HashMap();
            String messageToUser = null;
            User alumno = (User) request.getSession().getAttribute(Constantes.LOGIN_ON);
            Long levelAccess = (Long) ((HttpServletRequest) request).getSession().getAttribute(Constantes.LEVEL_ACCESS);

            if (alumno != null && levelAccess != null) {
                if (levelAccess.intValue() == LevelAccessUser.ALUMNO.ordinal()) {
                    paramentrosPlantilla.put(Constantes.LISTA_NOTAS_ALUMNO, servicios.getAllNotasByIdAlumno(alumno.getId()));
                } else {
                    messageToUser = Constantes.MESSAGE_NO_ALUMNO_NOTAS;
                }
            }
            if (messageToUser != null) {
                paramentrosPlantilla.put(Constantes.MESSAGE_TO_USER, messageToUser);
            }

            Template plantilla = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.NOTAS_ALUMNO_TEMPLATE);
            plantilla.process(paramentrosPlantilla, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(NotasAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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
