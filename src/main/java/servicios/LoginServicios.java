/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.RecuperarContraseñaDAO;
import dao.UsersDAO;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.User;
import model.UserNewPassword;
import utils.Constantes;
import static utils.Constantes.MESSAGE_USER_NEW_PASSWORD;
import utils.PasswordHash;

/**
 *
 * @author Gato
 */
public class LoginServicios {
    
    public LoginServicios() {
    }
    
    public boolean userReadyToWorkLogin(User user) {
        
        return user.getNombre() != null && user.getPassword() != null;
    }
    
    public boolean userReadyToWorkChangePassword(UserNewPassword user) {
        
        return user.getOld_password() != null && user.getNew_password() != null && user.getNew_password_confirm() != null;
    }
    
    public boolean compareNewPassword(UserNewPassword user) {
        
        return user.getNew_password().contains(user.getNew_password_confirm());
    }
    
    public boolean changeNewPasword(UserNewPassword newUser, User oldUser) throws NoSuchAlgorithmException, InvalidKeySpecException {
        RecuperarContraseñaDAO dao = new RecuperarContraseñaDAO();
        
        oldUser.setPassword(PasswordHash.getInstance().createHash(newUser.getNew_password()));
        
        return dao.restablecerPassword(oldUser) > 0;        
    }
    
    public boolean buildAndSendEmail(HttpServletRequest request, User usuario) {        
        MandarMail mail = new MandarMail();
        String message =String.format(MESSAGE_USER_NEW_PASSWORD,usuario.getNombre(),usuario.getPassword());

        return mail.sendMail(usuario.getEmail(), message, String.format(Constantes.EMAIL_SUBJECT_NEW_PASSWORD, usuario.getNombre()));
    }
    
    public User selectLoginUser(User usuario) {
        UsersDAO dao = new UsersDAO();
        
        return dao.getLoginUserJDBCTemplate(usuario);
    }
    
    public long getIdTipoPermiso(long id_usuario) {
        UsersDAO dao = new UsersDAO();
        
        Long id_permiso = dao.getIdPermisoUserJDBCTemplate(id_usuario);
        
        return (id_permiso != null) ? id_permiso : -1;
    }
    
    public User tratarParametro(Map<String, String[]> parametros) {
        User usuario = null;
        if (parametros != null && !parametros.isEmpty()) {
            usuario = new User();
            if (parametros.get(Constantes.EMAIL) != null && !parametros.get(Constantes.EMAIL)[0].isEmpty()) {
                usuario.setEmail(parametros.get(Constantes.EMAIL)[0]);
            }
            if (parametros.get(Constantes.ID) != null && !parametros.get(Constantes.ID)[0].isEmpty()) {
                usuario.setId(Long.valueOf(parametros.get(Constantes.ID)[0]));
            }
            if (parametros.get(Constantes.NOMBRE) != null && !parametros.get(Constantes.NOMBRE)[0].isEmpty()) {
                usuario.setNombre(parametros.get(Constantes.NOMBRE)[0]);
            }
            if (parametros.get(Constantes.ACTIVO) != null && !parametros.get(Constantes.ACTIVO)[0].isEmpty()) {
                usuario.setActivo((Integer.valueOf(parametros.get(Constantes.ACTIVO)[0]) == 0) ? Boolean.FALSE : Boolean.TRUE);
            }
            if (parametros.get(Constantes.CODIGO_ACTIVACION) != null && !parametros.get(Constantes.CODIGO_ACTIVACION)[0].isEmpty()) {
                usuario.setCodigo_activacion(parametros.get(Constantes.CODIGO_ACTIVACION)[0]);
            }
            if (parametros.get(Constantes.PASSWORD) != null && !parametros.get(Constantes.PASSWORD)[0].isEmpty()) {
                usuario.setPassword(parametros.get(Constantes.PASSWORD)[0]);
            }
            if (parametros.get(Constantes.FECHA_ACTIVACION) != null && !parametros.get(Constantes.FECHA_ACTIVACION)[0].isEmpty()) {
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date parseDate = null;
                try {
                    parseDate = dateFormat.parse(parametros.get(Constantes.FECHA_ACTIVACION)[0]);
                    usuario.setFecha_activacion(new Date(parseDate.getTime()));
                } catch (ParseException ex) {
                    Logger.getLogger(LoginServicios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return usuario;
        
    }
    
    public UserNewPassword tratarParametroNewPassword(Map<String, String[]> parametros) {
        UserNewPassword usuario = null;
        if (parametros != null && !parametros.isEmpty()) {
            usuario = new UserNewPassword();
            if (parametros.get(Constantes.EMAIL) != null && !parametros.get(Constantes.EMAIL)[0].isEmpty()) {
                usuario.setEmail(parametros.get(Constantes.EMAIL)[0]);
            }
            if (parametros.get(Constantes.ID) != null && !parametros.get(Constantes.ID)[0].isEmpty()) {
                usuario.setId(Long.valueOf(parametros.get(Constantes.ID)[0]));
            }
            if (parametros.get(Constantes.NOMBRE) != null && !parametros.get(Constantes.NOMBRE)[0].isEmpty()) {
                usuario.setNombre(parametros.get(Constantes.NOMBRE)[0]);
            }
            if (parametros.get(Constantes.OLD_PASSWORD) != null && !parametros.get(Constantes.OLD_PASSWORD)[0].isEmpty()) {
                usuario.setOld_password(parametros.get(Constantes.OLD_PASSWORD)[0]);
            }
            if (parametros.get(Constantes.NEW_PASSWORD) != null && !parametros.get(Constantes.NEW_PASSWORD)[0].isEmpty()) {
                usuario.setNew_password(parametros.get(Constantes.NEW_PASSWORD)[0]);
            }
            if (parametros.get(Constantes.NEW_PASSWORD_CONFIRM) != null && !parametros.get(Constantes.NEW_PASSWORD_CONFIRM)[0].isEmpty()) {
                usuario.setNew_password_confirm(parametros.get(Constantes.NEW_PASSWORD_CONFIRM)[0]);
            }
            
        }
        return usuario;
        
    }
    
}//fin clase
