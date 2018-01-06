/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import utils.Constantes;
import utils.UrlsPaths;

/**
 *
 * @author Gato
 */
public class UrlService {

    public UrlService() {
    }

    private String getBaseUrlServer(HttpServletRequest request) {
        String equal = "=";
        String and = "&";

        String uri = request.getScheme() + "://"
                + // "http" + "://
                request.getServerName()
                + // "myhost"
                ":"
                + // ":"
                request.getServerPort()
                + // "8080"
                request.getContextPath();

        return uri;
    }

    public Map addConstantsEndPoints(HttpServletRequest request) {
        HashMap paramentros = new HashMap();
        try {
            //Ejemplo final Endpoint: endpoint_alumnos
            String PreEndPoint = "endpoint_";
            paramentros.put(Constantes.BaseUrlServer, getBaseUrlServer(request));

            Field[] constantesEndpoints = UrlsPaths.class.getDeclaredFields();

            for (Field endpoint : constantesEndpoints) {
                endpoint.setAccessible(true);

                paramentros.put(PreEndPoint.concat(endpoint.getName().toLowerCase()), endpoint.get(UrlsPaths.class.newInstance()));

            }

        } catch (SecurityException ex) {
            Logger.getLogger(UrlService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(UrlService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UrlService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paramentros;
    }

}//fin clase
