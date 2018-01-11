/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TareasProfesor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.SqlQuery;

/**
 *
 * @author DAW
 */
public class TareasProfesorDAO {

    public TareasProfesor insertarTarea(TareasProfesor tareas) {
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            

            QueryRunner qr = new QueryRunner();
          
            long id = qr.insert(con,
                    SqlQuery.QUERYINSERTTAREA,
                    new ScalarHandler<Long>(),
                    tareas.getId_asignatura(),
                    tareas.getTarea(),
                    new java.sql.Date(tareas.getFecha_entrega().getTime()));
            tareas.setId_tarea(id);
            
            
        } catch (Exception ex) {
            if (con != null) {
                Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
                //con.rollback();
            }
        } finally {

            DBConnection.getInstance().cerrarConexion(con);
        }

        return tareas;
    }

    
   
}
