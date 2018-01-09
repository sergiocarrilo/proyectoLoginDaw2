/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Administrador;
import model.Asignatura;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
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

            QueryRunner qr = new QueryRunner();

            BigInteger id = qr.insert(con,
                    SqlQuery.QUERYINSERTUSER,
                    new ScalarHandler<BigInteger>(),
                    admin.getNombre(),
                    admin.getPassword(),
                    admin.getEmail(),
                    new java.sql.Date(admin.getFecha_activacion().getTime()));

            admin.setId(id.intValue());
            
            BigInteger id2 = qr.insert(con,
                    SqlQuery.QUERYPERMISOPROFESOR,
                    new ScalarHandler<BigInteger>(),
                    admin.getId());

            BigInteger id3 = qr.insert(con,
                    SqlQuery.QUERYINSERTPROFESOR,
                    new ScalarHandler<BigInteger>(),
                    admin.getId(),
                    admin.getNombre(),
                    new java.sql.Date(admin.getFecha_nacimiento().getTime()),
                    new java.sql.Date(admin.getFecha_entrada().getTime()));
            
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

            QueryRunner qr = new QueryRunner();

            BigInteger id = qr.insert(con,
                    SqlQuery.QUERYINSERTUSER,
                    new ScalarHandler<BigInteger>(),
                    admin.getNombre(),
                    admin.getPassword(),
                    admin.getEmail(),
                    new java.sql.Date(admin.getFecha_activacion().getTime()));

            admin.setId(id.intValue());

            BigInteger id2 = qr.insert(con,
                    SqlQuery.QUERYPERMISOALUMNO,
                    new ScalarHandler<BigInteger>(),
                    admin.getId());

            BigInteger id3 = qr.insert(con,
                    SqlQuery.QUERYINSERTALUMNO,
                    new ScalarHandler<BigInteger>(),
                    admin.getId(),
                    admin.getNombre(),
                    new java.sql.Date(admin.getFecha_nacimiento().getTime()),
                    admin.getMayor_Edad(),
                    new java.sql.Date(admin.getFecha_entrada().getTime()));

            con.commit();

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
            con.rollback();
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return admin;

    }

    public Administrador insertAsignatura(Administrador admin) {

        Connection con = null;

        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            BigInteger id = qr.insert(con,
                    SqlQuery.INSERT_ASIGNATURA,
                    new ScalarHandler<BigInteger>(),
                    admin.getNombre());

            admin.setId(id.intValue());

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return admin;

    }

    public List<Administrador> getAllProfessors(int offset) {
        List<Administrador> lista = null;
       
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Administrador>> handler
                    = new BeanListHandler<>(Administrador.class);
            lista = qr.query(con, SqlQuery.QUERYGETALLPROFESSORS, handler);

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    

    public List<Administrador> getAllAlumnos(int offset) {
       List<Administrador> lista = null;
       
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Administrador>> handler
                    = new BeanListHandler<>(Administrador.class);
            lista = qr.query(con, SqlQuery.QUERYGETALLALUMNOS, handler);

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    

    public List<Administrador> getAllAsignaturas(int offset) {
        List<Administrador> lista = null;
       
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Administrador>> handler
                    = new BeanListHandler<>(Administrador.class);
            lista = qr.query(con, SqlQuery.QUERYGETALLASIGNATURAS, handler);

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
}
