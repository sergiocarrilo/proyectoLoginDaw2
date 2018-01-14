/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Administrador;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
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
            ResultSetHandler<User> handler
                    = new BeanHandler<>(User.class);
            user = qr.query(con, SqlQuery.QUERYCOMPUSER, handler ,user.getNombre());
            
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            return usuario;
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
            
        }
        return user.getId();
    }
    
    public long comprobarCorreo(User user){
        long usuario= 0;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<User> handler
                    = new BeanHandler<>(User.class);
            user = qr.query(con, SqlQuery.QUERYCOMPCORREO, handler,user.getEmail());
            
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
             return usuario;
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
            
        }
        return user.getId();
    }

    public int restablecerPassword(User user) {
        Connection con = null;
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            
            filas = qr.update(con,
                    SqlQuery.QUERYUPDATEPASSWORD,
                    user.getPassword(), user.getNombre(), user.getEmail(), user.getId());
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filas;
    }

    public long conseguirId(User user) {
        long usuario= 0;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();

           QueryRunner qr = new QueryRunner();
            ResultSetHandler<User> handler
                    = new BeanHandler<>(User.class);
            user = qr.query(con, SqlQuery.QUERYGETID, handler,user.getNombre(),user.getEmail());
            
        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
            
        }
        return user.getId();
    }
}
