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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Superuser;
import utils.Constantes;
import servicios.SuperuserService;

/**
 *
 * @author DAW
 */
@WebServlet(name = "SuperuserServlet", urlPatterns = {"/superuserservlet"})
public class SuperuserServlet extends HttpServlet {

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
        SuperuserService service = new SuperuserService();
        HashMap root = new HashMap();
        String op;
        if (request.getParameter("op") == null) {
            op = Constantes.VIEW;
        } else {
            op = request.getParameter("op");
        }
        Superuser superuser;
        switch (op) {
            case Constantes.VIEW:
                
                break;
            case Constantes.HACERADMIN:
                superuser = this.crearSuperUsuario(request, response);
                int filas = service.cambiarPermiso(superuser);
                break;
        }
        try{
        root.put("usuarios", service.getAllUsers());
        Template temp = Configuration.getInstance().getFreeMarker().getTemplate("superuser.ftl");
        temp.process(root, response.getWriter());
        }catch(TemplateException ex){
            Logger.getLogger(Superuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Superuser crearSuperUsuario(HttpServletRequest request, HttpServletResponse response) {
        Superuser superuser = new Superuser();

        if (!"".equals(request.getParameter("iduser")) && request.getParameter("iduser") != null) {
            superuser.setId(Long.parseLong(request.getParameter("iduser")));
        }
        if (!"".equals(request.getParameter("idpermiso")) && request.getParameter("idpermiso") != null) {
            superuser.setPermiso(Long.parseLong(request.getParameter("idpermiso")));
        }

        return superuser;
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
