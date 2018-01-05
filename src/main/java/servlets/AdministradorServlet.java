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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;
import model.Superuser;
import servicios.AdministradorService;
import utils.Constantes;

/**
 *
 * @author DAW
 */
@WebServlet(name = "AdministradorServlet", urlPatterns = {"/administrador"})
public class AdministradorServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministradorService service = new AdministradorService();
        HashMap plantilla = new HashMap();
        String messageToUser = null;
 
        Map<String, String[]> parametros = request.getParameterMap();
       
        String action; 
      
        if (request.getParameter(Constantes.actionTemplate) == null) {
            action= Constantes.VIEW;
        } else {
             action = request.getParameter(Constantes.actionTemplate);
        }
        
        int offset;
        if (request.getParameter("offset") == null) {
            offset = 0;
        } else {
            offset = Integer.parseInt(request.getParameter("offset"));
        }
       Administrador admin = null;
        switch (action) {
            case Constantes.VIEW:
                break;
            case Constantes.INSERTARPROFE:
                admin = service.recogerParametros(parametros);
                Administrador insertprofe = null;
                insertprofe = service.insertProfesor(admin);
                break;
            case Constantes.INSERTARALUMNO:
                admin = service.recogerParametros(parametros);
                Administrador insertalumno = null;
                insertalumno = service.insertAlumno(admin);
                break;
            case Constantes.INSERTARASIGNATURA:
                Administrador insertasignatura = null;
                insertasignatura = service.insertAsignatura(admin);
                
                break;
        }
        try{
       
        Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.ADMINTEMPLATE);
        temp.process(plantilla, response.getWriter());
        }catch(TemplateException ex){
            Logger.getLogger(Superuser.class.getName()).log(Level.SEVERE, null, ex);
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
