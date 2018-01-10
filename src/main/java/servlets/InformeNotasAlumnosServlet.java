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
import java.io.PrintWriter;
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
import model.InformeNotasAlumnos;
import model.Profesor;
import servicios.AsignaturasServicios;
import servicios.InformeNotasAlumnosService;
import servicios.UrlService;
import utils.Constantes;
import utils.UrlsPaths;

/**
 *
 * @author DAW
 */
@WebServlet(name = "InformeNotasAlumnosServlet", urlPatterns = {UrlsPaths.INFORME_NOTAS_ALUMNOS})
public class InformeNotasAlumnosServlet extends HttpServlet {

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
        InformeNotasAlumnosService service = new InformeNotasAlumnosService();
        List<InformeNotasAlumnos> list = null;
        String action;
        HashMap plantilla = new HashMap();
        String messageToUser = null;
        Profesor profesor = new Profesor();
        Map<String, String[]> parametros = request.getParameterMap();
        
        if (request.getSession().getAttribute(Constantes.IDPROFESOR) == null) {
            profesor.setId(70);
        } else {
            profesor.setId((long) request.getSession().getAttribute(Constantes.IDPROFESOR));
        }
        
        if (request.getParameter(Constantes.actionTemplate) == null) {
            action = Constantes.VIEW;
        } else {
            action = request.getParameter(Constantes.actionTemplate);
        }

        switch (action) {
            case Constantes.VIEW:
                break;
            case Constantes.VIEWTABLA:
                InformeNotasAlumnos informe = service.recogerParametros(parametros);
                plantilla.put("informeNotasAlumnos", service.getNotasAsignatura(informe.getId_asignatura()));
                plantilla.put("nombreAsignatura", informe.getNombre_asignatura());
                break;
        }
        try {
            Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.INFORMEALUMNONOTAS);
            UrlService urlServicios = new UrlService();
            plantilla.put("asignaturas", service.getAsignaturasProfe(profesor.getId()));
            
            plantilla.putAll(urlServicios.addConstantsEndPoints(request));
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