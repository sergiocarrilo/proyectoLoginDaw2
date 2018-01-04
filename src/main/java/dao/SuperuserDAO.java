/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.AlumnosDAO;
import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Superuser;
import utils.SqlQuery;
import utils.Constantes;
/**
 *
 * @author DAW
 */
public class SuperuserDAO {

    public List<Superuser> getAllUsersJDBCTemplate(int offset) {
        List<Superuser> lista = new ArrayList<>();
        Superuser supuser = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DBConnection.getInstance().getConnection();
            stmt = con.prepareStatement(SqlQuery.QUERYGETALLUSERS, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, offset);
            rs = stmt.executeQuery();


            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt(Constantes.ID);
                String nombre = rs.getString(Constantes.NOMBRE);
                String email = rs.getString(Constantes.EMAIL);
                Date fecha = rs.getDate(Constantes.FECHA_ACTIVACION);
                int id_permiso = rs.getInt(Constantes.ID_PERMISO);
                supuser = new Superuser();
                supuser.setId((long)id);
                supuser.setNombre(nombre);
                supuser.setEmail(email);
                supuser.setFecha_activacion(fecha);
                supuser.setPermiso((long)id_permiso);

                lista.add(supuser);
            }

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public int cambiarPermisoJDBCTemplate(Superuser sup) {
       
         Connection con = null;
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();

            PreparedStatement stmtupdate = con.prepareStatement(SqlQuery.QUERYHACERADMIN, Statement.RETURN_GENERATED_KEYS);
            
                stmtupdate.setLong(1, sup.getPermiso());
                stmtupdate.setLong(2, sup.getId());
           
            
            

            filas = stmtupdate.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }

        return filas;
    }

    
    
    
}
