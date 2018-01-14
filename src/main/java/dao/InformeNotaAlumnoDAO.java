/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Asignatura;
import model.InformeNotasAlumnos;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.SqlQuery;

/**
 *
 * @author DAW
 */
public class InformeNotaAlumnoDAO {

    public List<InformeNotasAlumnos> getAsignaturasProfe(long id) {
        List<InformeNotasAlumnos> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<InformeNotasAlumnos>> handler
                    = new BeanListHandler<>(InformeNotasAlumnos.class);
            lista = qr.query(con, SqlQuery.QUERYASIGNATURASPROFE, handler,id);

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
        
    }

    public List<InformeNotasAlumnos> getNotasAsignatura(long id_asignatura) {
        List<InformeNotasAlumnos> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<InformeNotasAlumnos>> handler
                    = new BeanListHandler<>(InformeNotasAlumnos.class);
            lista = qr.query(con, SqlQuery.QUERYGETNOTASASIGNATURA, handler,id_asignatura);

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
}
