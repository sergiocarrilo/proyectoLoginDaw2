/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Iterator;
import java.util.Map;
import model.Administrador;
import utils.Constantes;

/**
 *
 * @author DAW
 */
public class AdministradorService {
    
    public Administrador recogerParametros(Map<String, String[]> parametros) throws UnsupportedEncodingException {
         Administrador admin = null;
        if (parametros != null && !parametros.isEmpty()) {

            admin = new Administrador();

            Iterator<String> it = parametros.keySet().iterator();

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
                    } 
                }
            }

        }
    return admin;
    }
    
}
