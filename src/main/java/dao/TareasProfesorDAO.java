/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TareaAlumno;
import model.AlumnoAsignatura;
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

    public TareasProfesor insertarTarea(TareasProfesor tareas) throws SQLException {
        Connection con = null;
        List<AlumnoAsignatura> lista = null;
        try {
            con = DBConnection.getInstance().getConnection();
            
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();
          
            long id = qr.insert(con,
                    SqlQuery.QUERYINSERTTAREA,
                    new ScalarHandler<Long>(),
                    tareas.getId_asignatura(),
                    tareas.getNombre(),
                    new java.sql.Date(tareas.getFecha_entrega().getTime()));
            tareas.setId_tarea(id);
            
            
            ResultSetHandler<List<AlumnoAsignatura>> handler
                    = new BeanListHandler<>(AlumnoAsignatura.class);
            lista = qr.query(con, SqlQuery.QUERYGETALUMNOSPORASIG, handler, tareas.getId_asignatura());
            
            for(AlumnoAsignatura alumno : lista){
                
                long id_alumno_asig = qr.insert(con,
                    SqlQuery.QUERYINSERTALUMNOASIG,
                    new ScalarHandler<Long>(),
                    tareas.getId_tarea(),
                    alumno.getId_alumno());
            
            }
            con.commit();
        } catch (Exception ex) {
            if (con != null) {
                Logger.getLogger(TareasProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
                con.rollback();
            }
        } finally {

            DBConnection.getInstance().cerrarConexion(con);
        }

        return tareas;
    }

    public List<TareasProfesor> getAllTareas(long id_asignatura) {
        List<TareasProfesor> lista = null;

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<TareasProfesor>> handler
                    = new BeanListHandler<>(TareasProfesor.class);
            lista = qr.query(con, SqlQuery.QUERYGETTAREABYASIG, handler, id_asignatura);

        } catch (Exception ex) {
            Logger.getLogger(ProfesoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
         return lista;
    }

    
   
}
