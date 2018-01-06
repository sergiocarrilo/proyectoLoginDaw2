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
import java.util.Map;
import model.Administrador;
import utils.Constantes;
import utils.PasswordHash;

/**
 *
 * @author DAW
 */
public class AdministradorService {
    
    public Administrador insertProfesor(Administrador admin) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        String passHash = PasswordHash.getInstance().createHash(admin.getPassword());
        admin.setPassword(passHash);
        MandarMail mail = new MandarMail();
        mail.mandarMail(admin.getEmail(), Constantes.PASSWORDPROFESOR, "CONTRASEÑA");
        AdministradorDAO dao = new AdministradorDAO();
        return dao.insertProfessor(admin);
    }
    
    public Administrador recogerParametros(Map<String, String[]> parametros) throws UnsupportedEncodingException {
         Administrador admin = null;
        if (parametros != null && !parametros.isEmpty()) {

            admin = new Administrador();

            Iterator<String> it = parametros.keySet().iterator();
            admin.setMayor(Boolean.FALSE);
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
                    } else if(Constantes.MAYOR.equalsIgnoreCase(key)){
                        admin.setMayor(Boolean.TRUE);
                    }else if(Constantes.CURSO.equalsIgnoreCase(key)){
                        admin.setCurso(String.valueOf(values[0]));
                    }
                }
            }
             LocalDateTime fecha_act = LocalDateTime.now();
        java.util.Date date = java.util.Date.from(fecha_act.atZone(ZoneId.systemDefault()).toInstant());
        admin.setFecha_activacion(date);

        }
    return admin;
    }

    public Administrador insertAlumno(Administrador admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Administrador insertAsignatura(Administrador admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
