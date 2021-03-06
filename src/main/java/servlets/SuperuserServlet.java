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
import model.Superuser;
import utils.Constantes;
import servicios.SuperuserService;
import utils.UrlsPaths;

/**
 *
 * @author DAW
 */
@WebServlet(name = "SuperuserServlet", urlPatterns = {UrlsPaths.SUPERUSER})
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

        String messageToUser = null;
        HashMap plantilla = new HashMap();
        Map<String, String[]> parametros = request.getParameterMap();

        String action;

        if (request.getParameter(Constantes.ACTION_TEMPLATE) == null) {
            action = Constantes.VIEW;
        } else {
            action = request.getParameter(Constantes.ACTION_TEMPLATE);
        }

        int offset;
        if (request.getParameter("offset") == null) {
            offset = 0;
        } else {
            offset = Integer.parseInt(request.getParameter("offset"));
        }

        switch (action) {
            case Constantes.VIEW:

                break;
            case Constantes.HACERADMIN:
                Superuser superuser = service.recogerParametros(parametros);
                int filas = service.hacerAdmin(superuser);
                if (filas == 0) {
                    messageToUser = Constantes.MESSAGEPERMISONOCAMBIADO;
                   
                }else{
                    messageToUser = Constantes.MESSAGEPERMISOCAMBIADO;
                }
            break;
            case Constantes.QUITARADMIN:
                Superuser quitaradmin = service.recogerParametros(parametros);
                int filasquitar = service.quitarAdmin(quitaradmin);
                if (filasquitar == 0) {
                    messageToUser = Constantes.MESSAGEPERMISONOCAMBIADO;
                   
                }else{
                    messageToUser = Constantes.MESSAGEPERMISOCAMBIADO;
                }
            break;
        }
        try {

            plantilla.put("usuarios", service.getAllUsers(offset));
            plantilla.put("offset", offset);
            plantilla.put(Constantes.MESSAGE_TO_USER, messageToUser);
            
            Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.SUPERUSERTEMPLATE);
            temp.process(plantilla, response.getWriter());
        } catch (TemplateException ex) {
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
