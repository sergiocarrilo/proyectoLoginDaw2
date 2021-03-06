/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.SuperuserDAO;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import model.Superuser;
import java.util.List;
import java.util.Map;
import utils.Constantes;


/**
 *
 * @author DAW
 */
public class SuperuserService {
    public List<Superuser> getAllUsers(int offset)
    {
        SuperuserDAO dao = new SuperuserDAO();
        return dao.getAllUsers(offset);
    }

    public int hacerAdmin(Superuser superuser) {
        SuperuserDAO dao = new SuperuserDAO();       
        return dao.hacerAdmin(superuser);
    }
    
     public int quitarAdmin(Superuser superuser) {
        SuperuserDAO dao = new SuperuserDAO();       
        return dao.quitarAdmin(superuser);
    }
    
     public Superuser recogerParametros(Map<String, String[]> parametros) throws UnsupportedEncodingException {
         Superuser superuser = null;
        if (parametros != null && !parametros.isEmpty()) {

            superuser = new Superuser();

            Iterator<String> it = parametros.keySet().iterator();

            while (it.hasNext()) {
                String key = (String) it.next();
                String[] values = (String[]) parametros.get(key);
                if (values[0] != null && !values[0].isEmpty()) {
                    if (Constantes.IDUSER.equalsIgnoreCase(key)) {
                        superuser.setId(Long.valueOf(values[0]));
                    } else if (Constantes.IDPERMISO.equalsIgnoreCase(key)) {
                        superuser.setPermiso(Long.valueOf(values[0]));
                    } 
                }
            }

        }
    return superuser;
    }

   

    
}
