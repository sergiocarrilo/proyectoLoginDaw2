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
import model.TareaAlumno;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.SqlQuery;

/**
 *
 * @author Gato
 */
public class TareasDAO {

  public List<TareaAlumno> getTareasByIdAlumnodbUtils(long id_alumno) {
        List<TareaAlumno> lista = null;

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            Object params[] = {id_alumno};
            ResultSetHandler<List<TareaAlumno>> handler
                    = new BeanListHandler<TareaAlumno>(TareaAlumno.class);
            lista = qr.query(con, SqlQuery.SELECT_ALL_TAREAS_BY_ID_USER, handler, params);

        } catch (Exception ex) {
            Logger.getLogger(ProfesoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
}//fin clase
