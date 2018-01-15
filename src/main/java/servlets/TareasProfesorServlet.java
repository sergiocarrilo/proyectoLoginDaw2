/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import config.Configuration;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Profesor;
import model.TareasProfesor;
import model.User;
import servicios.InformeNotasAlumnosService;
import servicios.TareasProfesorService;
import servicios.UrlService;
import utils.Constantes;
import utils.UrlsPaths;

/**
 *
 * @author DAW
 */
@WebServlet(name = "TareasProfesorServlet", urlPatterns = {UrlsPaths.TAREAS_PROFESOR})
public class TareasProfesorServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        InformeNotasAlumnosService asignaturasprofe = new InformeNotasAlumnosService();
        TareasProfesorService service = new TareasProfesorService();
        TareasProfesor tareas = null;
        String action;
        HashMap plantilla = new HashMap();
        String messageToUser = null;
        Profesor profesor = new Profesor();
        Map<String, String[]> parametros = request.getParameterMap();

        User user = (User) request.getSession().getAttribute(Constantes.LOGIN_ON);
        profesor.setId(user.getId());

        if (request.getParameter(Constantes.ACTION_TEMPLATE) == null) {
            action = Constantes.VIEW;
        } else {
            action = request.getParameter(Constantes.ACTION_TEMPLATE);
        }

        switch (action) {
            case Constantes.VIEW:
                break;
            case Constantes.PONERTAREA:
                tareas = service.recogerParametros(parametros);
                TareasProfesor tarea = service.insertarTarea(tareas);
                if (String.valueOf(tarea.getId_tarea()) == null || tarea.getId_tarea() == 0) {
                    messageToUser = Constantes.MESSAGETAREAFAIL;
                } else {
                    messageToUser = Constantes.MESSAGETAREAPUESTA;
                }
                break;
            case Constantes.VIEWTABLA:
                tareas = service.recogerParametros(parametros);
                plantilla.put("tareas", service.getAllTareas(tareas.getId_asignatura()));
                plantilla.put("nombreTarea", tareas.getNombre());
                break;
        }
        try {
            Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.TAREASPROFESOR);

            plantilla.put("asignaturas", asignaturasprofe.getAsignaturasProfe(profesor.getId()));
            plantilla.put(Constantes.MESSAGE_TO_USER, messageToUser);

            temp.process(plantilla, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(InformeNotasAlumnosServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TareasProfesorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(TareasProfesorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
