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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import servicios.RegistroServicios;
import utils.Constantes;
import utils.UrlsPaths;

/**
 *
 * @author Gato
 */
@WebServlet(name = "registroServlet", urlPatterns = {UrlsPaths.REGISTRO})
public class RegistroServlet extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        try {
            String action = request.getParameter(Constantes.ACTION_TEMPLATE);
            Map<String, String[]> parametros = request.getParameterMap();
            String messageToUser = null;
            HashMap paramentrosPlantilla = new HashMap();
            RegistroServicios servicios = new RegistroServicios();
            User usuario = servicios.tratarParametro(parametros);

            if (action != null && !action.isEmpty()) {
                switch (action) {
                    case Constantes.REGISTRAR:
                        if (!servicios.thisUserExist(usuario)) {

                            if (servicios.userReadyToWorkInsert(usuario)) {

                                usuario = servicios.generatePasswordAndActivationCode(usuario);

                                if (servicios.insertUser(usuario)) {

                                    messageToUser = (servicios.buildAndSendEmail(request, usuario))
                                            ? Constantes.MESSAGE_USER_REGISTER_SUBMIT_EMAIL : Constantes.MESSAGE_USER_REGISTER_SUBMIT_EMAIL_FAIL;

                                } else {
                                    messageToUser = Constantes.MESSAGE_USER_ERROR_INSERT;
                                }

                            } else {
                                messageToUser = Constantes.MESSAGE_USER_MISSING_FIELDS;
                            }

                        } else {
                            messageToUser = Constantes.MESSAGE_USER_EXIST;
                        }

                        break;

                    case Constantes.VALIDATE:
                        if (servicios.userReadyToWorkValidate(usuario)) {

                            usuario = servicios.checkCredentials(usuario);

                            if (usuario != null) {
                                if (servicios.isOnTimeValidEmail(usuario)) {

                                    messageToUser = (servicios.activateAccount(usuario)) ? Constantes.MESSAGE_USER_VALIDATE_OK : Constantes.MESSAGE_USER_VALIDATE_FAIL;
                                } else {

                                    messageToUser = Constantes.MESSAGE_USER_VALIDATE_EMAIL_TIME_OUT;
                                }

                            } else {
                                messageToUser = Constantes.MESSAGE_USER_VALIDATE_EMAIL_FAIL_ID;
                            }

                        } else {
                            messageToUser = Constantes.MESSAGE_USER_VALIDATE_EMAIL_FAIL;
                        }

                        break;

                }

            }

            if (messageToUser != null) {
                paramentrosPlantilla.put(Constantes.MESSAGE_TO_USER, messageToUser);
            }

            paramentrosPlantilla.put(Constantes.LOGIN_ON, usuario);

            Template plantilla = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.REGISTRO_TEMPLATE);
            plantilla.process(paramentrosPlantilla, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
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
