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

            PreparedStatement stmtprofesor = con.prepareStatement(SqlQuery.QUERYINSERTPROFESOR, Statement.RETURN_GENERATED_KEYS);

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

}
