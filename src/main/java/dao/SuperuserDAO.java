/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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

    public List<Superuser> getAllUsers(int offset) {
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
                int id_permiso;
                if (rs.getString(Constantes.ID_PERMISO) ==null) {
                    id_permiso = 0;
                } else {
                    id_permiso = rs.getInt(Constantes.ID_PERMISO);
                }
              
                supuser = new Superuser();
                  supuser.setPermiso((long) id_permiso);
                supuser.setId((long) id);
                supuser.setNombre(nombre);
                supuser.setEmail(email);
                supuser.setFecha_activacion(fecha);

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

    public int hacerAdmin(Superuser sup) {

        Connection con = null;
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();

            PreparedStatement stmtinsert = con.prepareStatement(SqlQuery.QUERYHACERADMIN, Statement.RETURN_GENERATED_KEYS);

            stmtinsert.setLong(1, sup.getId());

            filas = stmtinsert.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(SuperuserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }

        return filas;
    }

    public int quitarAdmin(Superuser superuser) {
        Connection con = null;
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();

            PreparedStatement stmtdelete = con.prepareStatement(SqlQuery.QUERYQUITARADMIN, Statement.RETURN_GENERATED_KEYS);
            stmtdelete.setLong(1, superuser.getId());

            filas = stmtdelete.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(SuperuserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }

        return filas;
    }

}
