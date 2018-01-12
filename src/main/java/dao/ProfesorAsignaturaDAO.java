/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ProfesorAsignatura;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import utils.Constantes;
import utils.SqlQuery;

/**
 *
 * @author Gato
 */
public class ProfesorAsignaturaDAO {

    public List<ProfesorAsignatura> getAllProfesorAsignaturadbUtils(long offset) {
        List<ProfesorAsignatura> lista = null;

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            Object params[] = {offset};
            ResultSetHandler<List<ProfesorAsignatura>> handler
                    = new BeanListHandler<ProfesorAsignatura>(ProfesorAsignatura.class);
            lista = qr.query(con, SqlQuery.SELECT_ALL_PROFESORES_ASIGNATURAS, handler, params);

        } catch (Exception ex) {
            Logger.getLogger(ProfesorAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public boolean insertProfesorAsignaturadbUtils(ProfesorAsignatura profesorAsignatura) {

        Connection con = null;
        boolean insertado = false;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            long id = qr.insert(con,
                    SqlQuery.INSERT_PROFESOR_ASIGNATURA,
                    new ScalarHandler<Long>(),
                    profesorAsignatura.getId_profe(),
                    profesorAsignatura.getId_asignatura()
            );

            if (id > 0) {
                insertado = Boolean.TRUE;
            }

        } catch (Exception ex) {
            Logger.getLogger(ProfesorAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return insertado;

    }

    public ProfesorAsignatura getDuplicateRelacionProfeAsignaturaJDBCTemplate(ProfesorAsignatura relacion) {

        JdbcTemplate jtm = new JdbcTemplate(
                DBConnection.getInstance().getDataSource());
        ProfesorAsignatura profeAsig = null;

        Long idRelacion = jtm.query(SqlQuery.SELECT_ALL_PROFES_ASIGNATURAS_BY_ID_PROFE_AND_ID_ASIGNATURA,
                new Object[]{relacion.getId_profe(), relacion.getId_asignatura()}, new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
                return rs.next() ? rs.getLong(Constantes.ID) : null;
            }
        });
        if (idRelacion != null) {
            profeAsig = relacion;
        }

        return profeAsig;
    }

    public int deleteProfesorAsignaturaTemplate(ProfesorAsignatura profesorAsignatura) {
        JdbcTemplate jtm = new JdbcTemplate(
                DBConnection.getInstance().getDataSource());
        int rowsAffected = jtm.update(SqlQuery.DELETE_PROFESOR_ASIGNATURA, profesorAsignatura.getId());

        return rowsAffected;
    }

}//fin clase
