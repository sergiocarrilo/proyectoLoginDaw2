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
import javax.servlet.http.HttpSession;
import model.User;
import model.UserNewPassword;
import servicios.LoginServicios;
import utils.Constantes;
import static utils.Constantes.RESET_PASSWORD;
import utils.PasswordHash;
import static utils.UrlsPaths.CAMBIAR_PASSWORD;

/**
 *
 * @author Gato
 */
@WebServlet(name = "CambiarPasswordServlet", urlPatterns = {CAMBIAR_PASSWORD})
public class CambiarPasswordServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            User usuarioSession = (User) session.getAttribute(Constantes.LOGIN_ON);
           
            String action = request.getParameter(Constantes.ACTION_TEMPLATE);
            Map<String, String[]> parametros = request.getParameterMap();
            String messageToUser = null;
            LoginServicios servicios = new LoginServicios();
            UserNewPassword usuarioNewPass = servicios.tratarParametroNewPassword(parametros);

            freemarker.template.Configuration freeMarker = Configuration.getInstance().getFreeMarker();

            if (action != null && !action.isEmpty()) {
                switch (action) {
                    case RESET_PASSWORD:
                        if (servicios.userReadyToWorkChangePassword(usuarioNewPass)) {
                            String passwordFromClient = usuarioNewPass.getOld_password();
                            usuarioSession = servicios.selectLoginUser(usuarioSession);//recupera el hash de DB

                            if (usuarioSession != null) {

                                if (PasswordHash.getInstance().validatePassword(passwordFromClient, usuarioSession.getPassword())) {//comprueba la contraseña antigua

                                    if (servicios.compareNewPassword(usuarioNewPass)) {

                                        if (servicios.changeNewPasword(usuarioNewPass, usuarioSession)) {
                                            usuarioSession.setPassword(usuarioNewPass.getNew_password());
                                            messageToUser = (servicios.buildAndSendEmail(request, usuarioSession))
                                                    ? Constantes.MESSAGE_USER_NEW_PASSWORD_EMAIL : Constantes.MESSAGE_USER_NEW_PASSWORD_EMAIL_FAIL;

                                        } else {
                                            messageToUser = Constantes.MESSAGE_USER_NEW_PASSWORD_WRONG;
                                        }

                                    } else {
                                        messageToUser = Constantes.MESSAGE_USER_NEW_PASSWORD_WRONG_COMPARE;
                                    }

                                } else {
                                    messageToUser = Constantes.MESSAGE_USER_PASSWORD_FAIL;
                                }

                            } else {
                                messageToUser = Constantes.MESSAGE_USER_LOGIN_FAIL_NOMBRE;
                            }
                        } else {
                            messageToUser = Constantes.MESSAGE_USER_MISSING_FIELDS;
                        }

                        break;

                }
            }
            HashMap paramentrosPlantilla = new HashMap();
            if (messageToUser != null) {
                paramentrosPlantilla.put(Constantes.MESSAGE_TO_USER, messageToUser);
            }

            Template plantilla = freeMarker.getTemplate(Constantes.CAMBIAR_PASSWORD_TEMPLATE);
            plantilla.process(paramentrosPlantilla, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
