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
import model.Nota;
import model.User;
import servicios.AlumnosServicios;
import servicios.AsignaturasServicios;
import servicios.NotasServicios;
import servicios.UrlService;
import utils.Constantes;
import utils.UrlsPaths;

@WebServlet(name = "NotasServlet", urlPatterns = {UrlsPaths.NOTAS})
public class NotasServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws freemarker.template.TemplateException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, TemplateException {
        NotasServicios ns = new NotasServicios();
        AlumnosServicios alums = new AlumnosServicios();
        AsignaturasServicios asigs = new AsignaturasServicios();
        String op = request.getParameter("accion");
        String idAlu = request.getParameter("idAlumno");
        String idAsig = request.getParameter("idAsignatura");
        String nomAlu = request.getParameter("nombreAlumno");
        String nomAsig = request.getParameter("nombreAsignatura");
        String nota = request.getParameter("nota");
        boolean cargar = false;

        String action = request.getParameter(Constantes.actionTemplate);
        String messageToUser = null;
        HashMap plantilla = new HashMap();
        Map<String, String[]> parametros = request.getParameterMap();
        //recupera el usuario de la session
        User profesor = (User) request.getSession().getAttribute(Constantes.LOGIN_ON);
        profesor = new User();//TODO - temporal quitar después
        profesor.setId(70);
       
        if (request.getParameter(Constantes.actionTemplate) == null) {
            action = Constantes.VIEW;
        } else {
            action = request.getParameter(Constantes.actionTemplate);
        }

        int offset;
        
        if (request.getParameter("offset") == null) {
            offset = 0;
        } else {
            offset = Integer.parseInt(request.getParameter("offset"));
        }
        
        if (op != null) {
            Nota n = new Nota();
            if (idAlu != null) {
                idAlu = idAlu.replace(" ","");
            }
            else {
                plantilla.put("mensaje", "ERROR AL SELECCIONAR");
            }
            n.setIdAlumno(Long.valueOf(idAlu));
            idAsig = idAsig.replace(" ","");
            n.setIdAsignatura(Long.parseLong(idAsig));
            int filas = 0;

            switch (op) {
                case "guardar":
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
                    
                    break;
                case "borrar":
                    filas = ns.delNota(n);
                    break;
                case "cargar":
                    n = ns.getNota(n.getIdAlumno(), n.getIdAsignatura());
                    cargar = true;
                    if (n == null) {
                        plantilla.put("mensaje", "No hay notas");
                    }else{
                        plantilla.put("nota",n);
                    }
                    break;
            }
            if (filas != 0 && cargar == false) {
                request.setAttribute("mensaje", filas + " filas modificadas correctamente");
            } else if (filas == 0 && cargar == false) {
                request.setAttribute("mensaje", "No se han hecho modificaciones");
            }
        }
        // getAll siempre se hace
        
        plantilla.put("notas", ns.getAllNotas(offset));
        plantilla.put("asignaturas", asigs.getAllAsignaturasByIdProfesor(profesor.getId()));
        plantilla.put("alumnos", alums.getAllAlumnos());
        plantilla.put("nomAlu", nomAlu);
        plantilla.put("idAlu", idAlu);
        plantilla.put("nomAsig", nomAsig);
        plantilla.put("idAsig", idAsig);
        plantilla.put("offset", offset);
        plantilla.put(Constantes.messageToUser, messageToUser);        
        UrlService urlServicios = new UrlService();
        plantilla.putAll(urlServicios.addConstantsEndPoints(request));
        Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.NOTASTEMPLATE);
        temp.process(plantilla, response.getWriter());
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
            Logger.getLogger(NotasServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NotasServlet.class.getName()).log(Level.SEVERE, null, ex);
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
