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
import model.AlumnoAsignatura;
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
 * @author IvanGarGal
 */
public class AlumnoAsignaturaDAO {

    public List<AlumnoAsignatura> getAllAlumnoAsignaturadbUtils(long offset) {
        List<AlumnoAsignatura> lista = null;

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            Object params[] = {offset};
            ResultSetHandler<List<AlumnoAsignatura>> handler
                    = new BeanListHandler<AlumnoAsignatura>(AlumnoAsignatura.class);
            lista = qr.query(con, SqlQuery.SELECT_ALL_ALUMNOS_ASIGNATURAS, handler, params);

        } catch (Exception ex) {
            Logger.getLogger(AlumnoAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public boolean insertAlumnoAsignaturadbUtils(AlumnoAsignatura alumnoAsignatura) {

        Connection con = null;
        boolean insertado = false;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            long id = qr.insert(con,
                    SqlQuery.INSERT_ALUMNO_ASIGNATURA,
                    new ScalarHandler<Long>(),
                    alumnoAsignatura.getId_alumno(),
                    alumnoAsignatura.getId_asignatura()
            );

            if (id > 0) {
                insertado = Boolean.TRUE;
            }

        } catch (Exception ex) {
            Logger.getLogger(AlumnoAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return insertado;

    }

    public AlumnoAsignatura getDuplicateRelacionAlumnoAsignaturaJDBCTemplate(AlumnoAsignatura relacion) {

        JdbcTemplate jtm = new JdbcTemplate(
                DBConnection.getInstance().getDataSource());
        AlumnoAsignatura alumnoAsig = null;

        Long idRelacion = jtm.query(SqlQuery.SELECT_ALL_ALUMNOS_ASIGNATURAS_BY_ID_ALUMNO_AND_ID_ASIGNATURA,
                new Object[]{relacion.getId_alumno(), relacion.getId_asignatura()}, new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
                return rs.next() ? rs.getLong(Constantes.ID_ALUMNOS_ASIGNATURAS) : null;
            }
        });
        if (idRelacion != null) {
            alumnoAsig = relacion;
        }

        return alumnoAsig;
    }

    public int deleteAlumnoAsignaturaTemplate(AlumnoAsignatura alumnoAsignatura) {
        JdbcTemplate jtm = new JdbcTemplate(
                DBConnection.getInstance().getDataSource());
        int rowsAffected = jtm.update(SqlQuery.DELETE_ALUMNO_ASIGNATURA, alumnoAsignatura.getId());

        return rowsAffected;
    }

}//fin clase
