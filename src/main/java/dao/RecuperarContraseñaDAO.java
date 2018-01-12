/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Administrador;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.Constantes;
import utils.SqlQuery;

/**
 *
 * @author DAW
 */
public class RecuperarContraseñaDAO {
    public long comprobarUser(User user){
        long usuario= 0;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ScalarHandler<Long> scalar = new ScalarHandler<>();
            usuario = qr.query(con, SqlQuery.QUERYCOMPUSER, scalar, user.getNombre());

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
            
        }
        return usuario;
    }
    
    public long comprobarCorreo(User user){
        long usuario= 0;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ScalarHandler<Long> scalar = new ScalarHandler<>();
            usuario = qr.query(con, SqlQuery.QUERYCOMPCORREO, scalar, user.getNombre());

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
            
        }
        return usuario;
    }

    public int restablecerPassword(User user) {
        Connection con = null;
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();

            filas = qr.update(con,
                    SqlQuery.QUERYUPDATEPASSWORD,
                    user.getPassword(), user.getNombre(), user.getEmail());
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filas;
    }
}
