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
import model.Profesor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.SqlQuery;

/**
 *
 * @author Gato
 */
public class ProfesoresDAO {
    
    public List<Profesor> getAllProfesoresdbUtils() {
        List<Profesor> lista = null;

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Profesor>> handler
                    = new BeanListHandler<Profesor>(Profesor.class);
            lista = qr.query(con, SqlQuery.SELECT_ALL_PROFESORES, handler);

        } catch (Exception ex) {
            Logger.getLogger(ProfesorAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
}//fin clase
