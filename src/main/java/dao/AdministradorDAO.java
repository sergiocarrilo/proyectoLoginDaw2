/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Administrador;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
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
          
            long id = qr.insert(con,
                    SqlQuery.QUERYINSERTUSER,
                    new ScalarHandler<Long>(),
                    admin.getNombre(),
                    admin.getPassword(),
                    admin.getEmail(),
                    new java.sql.Date(admin.getFecha_activacion().getTime()));
            admin.setId(id);
            long idpermiso = qr.insert(con,
                    SqlQuery.QUERYPERMISOPROFESOR,
                    new ScalarHandler<Long>(),
                    admin.getId());
            BigInteger idprofe = qr.insert(con,
                    SqlQuery.QUERYINSERTPROFESOR,
                    new ScalarHandler<BigInteger>(),
                    admin.getId(),
                    admin.getNombre(),
                    new java.sql.Date(admin.getFecha_nacimiento().getTime()),
                    new java.sql.Date(admin.getFecha_entrada().getTime()));
            
            con.commit();
        } catch (Exception ex) {
            if (con != null) {
                Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
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

            long id = qr.insert(con,
                    SqlQuery.QUERYINSERTUSER,
                    new ScalarHandler<Long>(),
                    admin.getNombre(),
                    admin.getPassword(),
                    admin.getEmail(),
                    new java.sql.Date(admin.getFecha_activacion().getTime()));

            admin.setId(id);

            long id2 = qr.insert(con,
                    SqlQuery.QUERYPERMISOALUMNO,
                    new ScalarHandler<Long>(),
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

            Long id = qr.insert(con,
                    SqlQuery.INSERT_ASIGNATURA,
                    new ScalarHandler<Long>(),
                    admin.getNombre());

            admin.setId(id);

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
            lista = qr.query(con, SqlQuery.QUERYGETALLPROFESSORS, handler,offset);

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
            lista = qr.query(con, SqlQuery.QUERYGETALLALUMNOS, handler,offset);

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
            lista = qr.query(con, SqlQuery.QUERYGETALLASIGNATURAS, handler,offset);

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
    public long comprobarUser(Administrador admin){
        long usuario= 0;
        Connection con = null;
        User user;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<User> handler
                    = new BeanHandler<>(User.class);
            user = qr.query(con, SqlQuery.QUERYCOMPUSER, handler ,admin.getNombre());
            if(user == null){
                usuario = 0;
            }else{
                usuario = user.getId();
            }
                     
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            return usuario;
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
            
        }
        return usuario;
    }
    
    public long comprobarCorreo(Administrador admin){
        long usuario= 0;
        Connection con = null;
        User user = null;       
        try {
            con = DBConnection.getInstance().getConnection();
            
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<User> handler
                    = new BeanHandler<>(User.class);
            user = qr.query(con, SqlQuery.QUERYCOMPCORREO, handler,admin.getEmail());
            if(user == null){
                usuario = 0;
            }else{
                usuario = user.getId();
            }
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
             return usuario;
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
            
        }
        return usuario;
    }
}