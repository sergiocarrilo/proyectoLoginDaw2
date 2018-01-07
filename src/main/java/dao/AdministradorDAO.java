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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Administrador;
import servlets.AdministradorServlet;
import utils.Constantes;
import utils.SqlQuery;

/**
 *
 * @author DAW
 */
public class AdministradorDAO {

    public Administrador insertProfessor(Administrador admin) throws SQLException {
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            PreparedStatement stmtprofesor = con.prepareStatement(SqlQuery.QUERYINSERTUSER, Statement.RETURN_GENERATED_KEYS);

            stmtprofesor.setString(1, admin.getNombre());
            stmtprofesor.setString(2, admin.getPassword());
            stmtprofesor.setString(3, admin.getEmail());
            stmtprofesor.setDate(4, new java.sql.Date(admin.getFecha_activacion().getTime()));

            int filas = stmtprofesor.executeUpdate();

            ResultSet rs = stmtprofesor.getGeneratedKeys();
            if (rs.next()) {
                admin.setId(rs.getLong(1));
            }
            PreparedStatement stmtpermiso = con.prepareStatement(SqlQuery.QUERYPERMISOPROFESOR, Statement.RETURN_GENERATED_KEYS);
            stmtpermiso.setLong(1, admin.getId());

            stmtpermiso.executeUpdate();
            int filaspermiso = stmtpermiso.executeUpdate();

            con.commit();
        } catch (Exception ex) {
            if (con != null) {
                con.rollback();
            }
        } finally {

            DBConnection.getInstance().cerrarConexion(con);
        }

        return admin;
    }

    public Administrador insertAlumno(Administrador admin) throws SQLException {
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            PreparedStatement stmtuser = con.prepareStatement(SqlQuery.QUERYINSERTUSER, Statement.RETURN_GENERATED_KEYS);

            stmtuser.setString(1, admin.getNombre());
            stmtuser.setString(2, admin.getPassword());
            stmtuser.setString(3, admin.getEmail());
            stmtuser.setDate(4, new java.sql.Date(admin.getFecha_activacion().getTime()));

            int filas = stmtuser.executeUpdate();

            ResultSet rs = stmtuser.getGeneratedKeys();
            if (rs.next()) {
                admin.setId(rs.getLong(1));
            }
            PreparedStatement stmtpermiso = con.prepareStatement(SqlQuery.QUERYPERMISOALUMNO, Statement.RETURN_GENERATED_KEYS);
            stmtpermiso.setLong(1, admin.getId());

            stmtpermiso.executeUpdate();
            int filaspermiso = stmtpermiso.executeUpdate();
            
            PreparedStatement stmtalumno = con.prepareStatement(SqlQuery.QUERYINSERTALUMNO, Statement.RETURN_GENERATED_KEYS);
            stmtalumno.setLong(1, admin.getId());
            stmtalumno.setString(2, admin.getNombre());
            stmtalumno.setDate(3, new java.sql.Date(admin.getFecha_nacimiento().getTime()));
            stmtalumno.setBoolean(4, admin.getMayor());
            
            

            con.commit();
        } catch (Exception ex) {
            if (con != null) {
                con.rollback();
            }
        } finally {

            DBConnection.getInstance().cerrarConexion(con);
        }

        return admin;
    }

    public Administrador insertAsignatura(Administrador admin) {
       Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
         

            PreparedStatement stmtprofesor = con.prepareStatement(SqlQuery.INSERT_ASIGNATURA, Statement.RETURN_GENERATED_KEYS);

            stmtprofesor.setString(1, admin.getNombre());

            int filas = stmtprofesor.executeUpdate();

            ResultSet rs = stmtprofesor.getGeneratedKeys();
            if (rs.next()) {
                admin.setId(rs.getLong(1));
            }
   
        } catch (Exception ex) {
              Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            DBConnection.getInstance().cerrarConexion(con);
        }

        return admin;
    }

}
