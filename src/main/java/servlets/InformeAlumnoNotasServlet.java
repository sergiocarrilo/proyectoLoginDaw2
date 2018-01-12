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
import model.Alumno;
import model.Nota;
import model.Profesor;
import model.User;
import servicios.InformeAlumnoNotasServicios;
import servicios.InformeNotasAlumnosService;
import servicios.UrlService;
import utils.Constantes;
import utils.UrlsPaths;

/**
 *
 * @author IvanGarGal
 */
@WebServlet(name = "InformeAlumnoNotasServlet", urlPatterns = {UrlsPaths.INFORME_ALUMNO_NOTAS})
public class InformeAlumnoNotasServlet extends HttpServlet {

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
        InformeAlumnoNotasServicios ns= new InformeAlumnoNotasServicios();
        InformeAlumnoNotasServicios nss= new InformeAlumnoNotasServicios();
        
        List<Alumno> list = null;
        
        String action = request.getParameter("ACTION");
        
        String idalumnillo = request.getParameter("idalumno");
        
        HashMap plantilla = new HashMap();
        
        String messageToUser = null;
        
        Alumno alumno = new Alumno();
        
        Nota n = new Nota();
        
        Map<String, String[]> parametros = request.getParameterMap();
        if (action != null) {
            switch (action) {
                case "VIEW":
                    if (idalumnillo != null) {
                        
                        n.setIdAlumno(Long.parseLong(idalumnillo));
                        //Nota notita = ns.verAlumnos(parametros);
                        plantilla.put("notas",ns.verAlumnos(n.getIdAlumno()));
                        /**
                        if (n != null) {
                            filas = 1;
                            if (nota != ""){
                                n.setNota(Integer.parseInt(nota));
                                n = ns.guardarNota(n);
                                if (n != null) {
                                    filas = 1;
                                }
                                plantilla.put("nota",n);
                            }
                            else {
                                plantilla.put("mensaje", "ERROR AL SELECCIONAR");
                            }
                        }
                        * */
                    }
                    else {
                        plantilla.put("mensaje", "ERROR AL SELECCIONAR");   
                    }
                break;
            }
            
        }
        try {
                Template temp = Configuration.getInstance().getFreeMarker().getTemplate("informeAlumnoNotas.ftl");
                UrlService urlServicios = new UrlService();
                plantilla.put("alumnos",nss.getAllAlumnos());
                //plantilla.putAll(urlServicios.addConstantsEndPoints(request));
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
