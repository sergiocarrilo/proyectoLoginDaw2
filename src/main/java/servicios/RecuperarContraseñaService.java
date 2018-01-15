/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import model.User;
import utils.Constantes;
import dao.RecuperarContraseñaDAO;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import utils.PasswordHash;
import static utils.Utils.randomAlphaNumeric;

/**
 *
 * @author DAW
 */
public class RecuperarContraseñaService {
    
    public Long restablecerContrasea(User user) throws NoSuchAlgorithmException, InvalidKeySpecException{
        long codigo = 0;
        if(this.comprobarUser(user) && this.comprobarCorreo(user)){
            
            String beforeHash = randomAlphaNumeric(10);
            String passHash = PasswordHash.getInstance().createHash(beforeHash);
            user.setPassword(passHash);
            MandarMail mail = new MandarMail();
            RecuperarContraseñaDAO dao = new RecuperarContraseñaDAO();
            
            user.setId(this.conseguirId(user));
            int comprestablecer = dao.restablecerPassword(user);

            if(comprestablecer == 0) {
                codigo =  0;

            } else {

                mail.mandarMail(user.getEmail(), beforeHash, "CONTRASEÑA");
                codigo = 1;
            }
        }else if(!this.comprobarUser(user)){
            codigo =  -1;
            
        }else if(!this.comprobarCorreo(user)){
            codigo =  -2;
            
        }
        return codigo;
    
    }
    public Boolean comprobarUser(User user){
        RecuperarContraseñaDAO dao = new RecuperarContraseñaDAO();
        long comprobacion = dao.comprobarUser(user);
        if(comprobacion == 0){
            return false;
        }else{
            return true;
         }
    }
    
    public Boolean comprobarCorreo(User user) {
        RecuperarContraseñaDAO dao = new RecuperarContraseñaDAO();
        long comprobacion = dao.comprobarCorreo(user);
        if(comprobacion == 0){
            return false;
        }else{
            return true;
         }
    }
    public long conseguirId(User user) {
        RecuperarContraseñaDAO dao = new RecuperarContraseñaDAO();
        return dao.conseguirId(user);
    }
    
    
     public User recogerParametros(Map<String, String[]> parametros) throws UnsupportedEncodingException {
        User user = null;
        if (parametros != null && !parametros.isEmpty()) {

            user = new User();

            Iterator<String> it = parametros.keySet().iterator();
           
            while (it.hasNext()) {
                String key = (String) it.next();
                String[] values = (String[]) parametros.get(key);
                if (values[0] != null && !values[0].isEmpty()) {
                    if (Constantes.NAME.equalsIgnoreCase(key)) {
                        user.setNombre(String.valueOf(values[0]));
                    } else if (Constantes.EMAIL.equalsIgnoreCase(key)) { 
                        user.setEmail(String.valueOf(values[0]));
                    }
                }
            }
        }
        return user;
    }
}
