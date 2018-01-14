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
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.RecuperarContraseñaService;
import utils.Constantes;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import servicios.UrlService;
import utils.UrlsPaths;



/**
 *
 * @author DAW
 */
@WebServlet(name = "RecuperarContraseña", urlPatterns = {UrlsPaths.RECUPERAR_PASSWORD})
public class RecuperarContraseñaServlet extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException, InvalidKeySpecException, TemplateException {
        RecuperarContraseñaService service = new RecuperarContraseñaService();
        HashMap plantilla = new HashMap();
        String messageToUser = null;

        Map<String, String[]> parametros = request.getParameterMap();

        String action;

        if (request.getParameter(Constantes.ACTION_TEMPLATE) == null) {
            action = Constantes.VIEW;
            
        } else {
            action = request.getParameter(Constantes.ACTION_TEMPLATE);
        }

        switch(action){
            case Constantes.RECUPERARCONTRASEÑA:
                User user = service.recogerParametros(parametros);
                long resultado = service.restablecerContrasea(user);
                if (resultado == 0) {
                    messageToUser = Constantes.MESSAGECONTRASEÑANOENVIADA;
                }else if(resultado == -1 || resultado == -2){
                    messageToUser = Constantes.MESSAGEDATOSINCORRECTOS;
                }else{
                    messageToUser = Constantes.MESSAGECONTRASEÑAENVIADA;
                }
                break;
        }
        
        

            Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.RECUPERARTEMPLATE);
            
            plantilla.put(Constantes.MESSAGE_TO_USER, messageToUser);
            
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RecuperarContraseñaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(RecuperarContraseñaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(RecuperarContraseñaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RecuperarContraseñaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(RecuperarContraseñaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(RecuperarContraseñaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
