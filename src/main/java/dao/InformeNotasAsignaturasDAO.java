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
import model.InformeNota;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.SqlQuery;

/**
 *
 * @author Gato
 */
public class InformeNotasAsignaturasDAO {

    public InformeNotasAsignaturasDAO() {
    }

    public List<InformeNota> getNotasByIdCursoAndIdAsignaturadbUtils(long id_curso, long id_asignatura) {
        List<InformeNota> lista = null;

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            Object params[] = {id_curso, id_asignatura};
            ResultSetHandler<List<InformeNota>> handler
                    = new BeanListHandler<InformeNota>(InformeNota.class);
            lista = qr.query(con, SqlQuery.SELECT_NOTAS_BY_ID_CURSO_AND_ID_ASIG, handler, params);

        } catch (Exception ex) {
            Logger.getLogger(InformeNotasAsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

}//fin clase
