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
import java.sql.SQLException;
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
import model.Administrador;
import servicios.AdministradorService;
import servicios.UrlService;
import utils.Constantes;
import utils.UrlsPaths;

/**
 *
 * @author DAW
 */
@WebServlet(name = "AdministradorServlet", urlPatterns = {UrlsPaths.ADMINISTRADOR})
public class AdministradorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        AdministradorService service = new AdministradorService();
        HashMap plantilla = new HashMap();
        String messageToUser = null;

        Map<String, String[]> parametros = request.getParameterMap();

        String action;

        if (request.getParameter(Constantes.ACTION_TEMPLATE) == null) {
            action = Constantes.VIEWPROFESSOR;
            
        } else {
            action = request.getParameter(Constantes.ACTION_TEMPLATE);
        }

        int offset;
        if (request.getParameter("offset") == null) {
            offset = 0;
        } else {
            offset = Integer.parseInt(request.getParameter("offset"));
        }
        Administrador admin = null;
        List<Administrador> lista = null;
        plantilla.put(Constantes.ASIGNATURAS, null);

        switch (action) {
            case Constantes.VIEWPROFESSOR:
                   lista = service.getAllProfessors(offset);
                   
                break;
            case Constantes.VIEWALUMNO:
                lista = service.getAllAlumnos(offset);
               
                break;
            case Constantes.VIEWASIGNATURA:
                lista = service.getAllAsignaturas(offset);
                plantilla.put(Constantes.ASIGNATURAS, 1);
                break;
            case Constantes.INSERTARPROFE:
                admin = service.recogerParametros(parametros);
                Administrador insertprofe = null;
                admin.setPassword(Constantes.PASSWORDPROFESOR);
                insertprofe = service.insertProfesor(admin);
                lista = service.getAllProfessors(offset);
                if (String.valueOf(insertprofe.getId()) == null || insertprofe.getId() == 0) {
                    messageToUser = Constantes.MESSAGEPROFESORNOINSERTADO;

                }else if(insertprofe.getId() == -1){
                    messageToUser = Constantes.MESSAGEUSUARIOREPETIDO;
                }else {
                    messageToUser = Constantes.MESSAGEPROFESORINSERTADO;
                }
                break;
            case Constantes.INSERTARALUMNO:
                admin = service.recogerParametros(parametros);
                Administrador insertalumno = null;
                admin.setPassword(Constantes.PASSWORDALUMNO);
                insertalumno = service.insertAlumno(admin);
                lista = service.getAllAlumnos(offset);
                if (String.valueOf(insertalumno.getId()) == null || insertalumno.getId()==0) {
                    messageToUser = Constantes.MESSAGEALUMNONOINSERTADO;

                } else if(insertalumno.getId() == -1){
                    messageToUser = Constantes.MESSAGEUSUARIOREPETIDO;
                }else {
                    messageToUser = Constantes.MESSAGEALUMNOINSERTADO;
                }
                break;
            case Constantes.INSERTARASIGNATURA:
                admin = service.recogerParametros(parametros);
                Administrador insertasignatura = service.insertAsignatura(admin);
                lista = service.getAllAsignaturas(offset);
                if (String.valueOf(insertasignatura.getId()) == null || insertasignatura.getId() == 0) {
                    messageToUser = Constantes.MESSAGEASIGNATURANOINSERTADA;
                } else {
                    messageToUser = Constantes.MESSAGEASIGNATURAINSERTADO;
                }
                break;
        }
        try {

            Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.ADMINTEMPLATE);
            UrlService urlServicios = new UrlService();
            plantilla.put(Constantes.LISTA, lista);
            plantilla.put(Constantes.MESSAGE_TO_USER, messageToUser);
            plantilla.put("actionview", action);
            plantilla.put("offset", offset);
            plantilla.putAll(urlServicios.addConstantsEndPoints(request));
            temp.process(plantilla, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
