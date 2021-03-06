/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AdministradorDAO;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import model.Administrador;
import utils.Constantes;
import utils.PasswordHash;
import static utils.Utils.randomAlphaNumeric;

/**
 *
 * @author DAW
 */
public class AdministradorService {
    

    public Administrador insertProfesor(Administrador admin) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        if(this.comprobarUser(admin) && this.comprobarCorreo(admin)){
            String beforeHash = randomAlphaNumeric(10);
            String passHash = PasswordHash.getInstance().createHash(beforeHash);
            admin.setPassword(passHash);
            MandarMail mail = new MandarMail();
            AdministradorDAO dao = new AdministradorDAO();
            Administrador compadmin = dao.insertProfessor(admin);

            if (String.valueOf(compadmin.getId()) == null || compadmin.getId() == 0) {
                return compadmin;

            } else {

                mail.mandarMail(admin.getEmail(), beforeHash, "CONTRASEÑA");
                return compadmin;
            }
        }else if(!this.comprobarCorreo(admin)){
            admin.setId(-2);
            
        }else if(!this.comprobarUser(admin)){
            admin.setId(-1);
            
        }
        return admin;
    }
    
     public Administrador insertAlumno(Administrador admin) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        if(this.comprobarUser(admin)){
            String beforeHash = randomAlphaNumeric(10);
            String passHash = PasswordHash.getInstance().createHash(beforeHash);
            admin.setPassword(passHash);
            MandarMail mail = new MandarMail();
            AdministradorDAO dao = new AdministradorDAO();
            Administrador compadmin = dao.insertAlumno(admin);

            if (String.valueOf(compadmin.getId()) == null || compadmin.getId() == 0) {
                return compadmin;
            } else {
                mail.mandarMail(admin.getEmail(), beforeHash, "CONTRASEÑA");
                return compadmin;
            }
        }else if(!this.comprobarCorreo(admin)){
            admin.setId(-2);
            
        }else if(!this.comprobarUser(admin)){
            admin.setId(-1);
            
        }
        return admin;

    }

    public Administrador recogerParametros(Map<String, String[]> parametros) throws UnsupportedEncodingException {
        Administrador admin = null;
        if (parametros != null && !parametros.isEmpty()) {

            admin = new Administrador();

            Iterator<String> it = parametros.keySet().iterator();
            admin.setMayor_Edad(Boolean.FALSE);
            while (it.hasNext()) {
                String key = (String) it.next();
                String[] values = (String[]) parametros.get(key);
                if (values[0] != null && !values[0].isEmpty()) {
                    if (Constantes.NAME.equalsIgnoreCase(key)) {
                        admin.setNombre(String.valueOf(values[0]));
                    } else if (Constantes.EMAIL.equalsIgnoreCase(key)) {
                        admin.setEmail(String.valueOf(values[0]));
                    } else if (Constantes.FECNA.equalsIgnoreCase(key)) {
                        admin.setFecha_nacimiento(Date.valueOf(values[0]));
                    } else if (Constantes.MAYOR.equalsIgnoreCase(key)) {
                        admin.setMayor_Edad(Boolean.TRUE);
                    }else if(Constantes.FECHA_ENTRADA.equalsIgnoreCase(key)){
                        admin.setFecha_entrada(Date.valueOf(values[0]));
                    }
                }
            }
            LocalDateTime fecha_act = LocalDateTime.now();
            java.util.Date date = java.util.Date.from(fecha_act.atZone(ZoneId.systemDefault()).toInstant());
            admin.setFecha_activacion(date);

        }
        return admin;
    }

   

    public Administrador insertAsignatura(Administrador admin) throws SQLException {
        AdministradorDAO dao = new AdministradorDAO();
        return dao.insertAsignatura(admin);
    }

    public List<Administrador> getAllProfessors(int offset) {
        AdministradorDAO dao = new AdministradorDAO();
        return dao.getAllProfessors(offset);
    }

    public List<Administrador> getAllAlumnos(int offset) {
       AdministradorDAO dao = new AdministradorDAO();
        return dao.getAllAlumnos(offset);
    }

    public List<Administrador> getAllAsignaturas(int offset) {
        AdministradorDAO dao = new AdministradorDAO();
        return dao.getAllAsignaturas(offset);
    }
    
    public Boolean comprobarUser(Administrador admin) {
        AdministradorDAO dao = new AdministradorDAO();
        long comprobacion = dao.comprobarUser(admin);
        if(comprobacion == 0){
            return true;
        }else{
            return false;
         }
    }
    
    public Boolean comprobarCorreo(Administrador admin) {
        AdministradorDAO dao = new AdministradorDAO();
        long comprobacion = dao.comprobarCorreo(admin);
        if(comprobacion == 0){
            return true;
        }else{
            return false;
         }
    }

}
