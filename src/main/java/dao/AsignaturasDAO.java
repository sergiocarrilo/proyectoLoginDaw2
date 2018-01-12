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
import model.Asignatura;

import model.AsignaturaCurso;
import model.Curso;
import model.ProfesorAsignatura;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import utils.Constantes;
import utils.ConstantesError;
import utils.SqlQuery;

/**
 *
 * @author oscar
 */
public class AsignaturasDAO {

    public List<AsignaturaCurso> getAllAsignaturasCursosdbUtils(long offset) {
        List<AsignaturaCurso> lista = null;

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            Object params[] = {offset};
            ResultSetHandler<List<AsignaturaCurso>> handler
                    = new BeanListHandler<AsignaturaCurso>(AsignaturaCurso.class);
            lista = qr.query(con, SqlQuery.SELECT_ALL_ASIGNATURAS_CURSOS, handler, params);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public List<ProfesorAsignatura> getAllAsignaturasByIdProfesordbUtils(long id_profesor) {
        List<ProfesorAsignatura> lista = null;

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            Object params[] = {id_profesor};
            ResultSetHandler<List<ProfesorAsignatura>> handler
                    = new BeanListHandler<ProfesorAsignatura>(ProfesorAsignatura.class);
            lista = qr.query(con, SqlQuery.SELECT_ALL_ASIGNATURAS_BY_ID_PROFESOR, handler, params);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public List<Curso> getAllCursosdbUtils() {
        List<Curso> lista = null;

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Curso>> handler
                    = new BeanListHandler<Curso>(Curso.class);
            lista = qr.query(con, SqlQuery.SELECT_ALL_CURSOS, handler);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public List<Asignatura> getAllAsignaturasdbUtils() {
        List<Asignatura> lista = null;

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Asignatura>> handler
                    = new BeanListHandler<Asignatura>(Asignatura.class);
            lista = qr.query(con, SqlQuery.SELECT_ALL_ASIGNATURAS, handler);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public List<Asignatura> getAsignaturasByIdCursodbUtils(long id_curso) {
        List<Asignatura> lista = null;

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            Object params[] = {id_curso};
            ResultSetHandler<List<Asignatura>> handler
                    = new BeanListHandler<Asignatura>(Asignatura.class);
            lista = qr.query(con, SqlQuery.SELECT_ALL_ASIGNATURAS_BY_ID_CURSO, handler, params);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public AsignaturaCurso getDuplicateRelacionAsignaturaCursoJDBCTemplate(AsignaturaCurso relacion) {

        JdbcTemplate jtm = new JdbcTemplate(
                DBConnection.getInstance().getDataSource());
        AsignaturaCurso AsigCurso = null;

        Long idRelacion = jtm.query(SqlQuery.SELECT_ALL_ASIGNATURA_CURSO_BY_ID_ASIGNATURA_AND_ID_CURSO,
                new Object[]{relacion.getId_asignatura(), relacion.getId_curso()}, new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
                return rs.next() ? rs.getLong(Constantes.ID) : null;
            }
        });
        if (idRelacion != null) {
            AsigCurso = relacion;
        }

        return AsigCurso;
    }

    public boolean insertAsignaturaCursodbUtils(AsignaturaCurso asCu) {

        Connection con = null;
        boolean insertado = false;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            long id = qr.insert(con,
                    SqlQuery.INSERT_ASIGNATURA_CURSO,
                    new ScalarHandler<Long>(),
                    asCu.getId_asignatura(),
                    asCu.getId_curso()
            );

            if (id > 0) {
                insertado = Boolean.TRUE;
            }

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return insertado;

    }

    public boolean insertAsignaturadbUtils(Asignatura asignatura) {

        Connection con = null;
        boolean insertado = false;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            long id = qr.insert(con,
                    SqlQuery.INSERT_ASIGNATURA,
                    new ScalarHandler<Long>(),
                    asignatura.getNombre());

            if (id > 0) {
                insertado = Boolean.TRUE;
            }

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return insertado;

    }

    public boolean insertCursodbUtils(Curso curso) {

        Connection con = null;
        boolean insertado = false;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            long id = qr.insert(con,
                    SqlQuery.INSERT_CURSO,
                    new ScalarHandler<Long>(),
                    curso.getCurso());

            if (id > 0) {
                insertado = Boolean.TRUE;
            }

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return insertado;

    }

    public int updateAsignaturasCursoJdbcTemplate(AsignaturaCurso asignaturaCurso) {

        JdbcTemplate jtm = new JdbcTemplate(
                DBConnection.getInstance().getDataSource());
        int rowsAffected = -1;
        /* Long resultadoQuery = jtm.query(SqlQuery.SELECT_ALL_ASIGNATURA_CURSO_BY_ID, new Object[]{asignaturaCurso.getId_asignatura(), asignaturaCurso.getId_curso()}, new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
                return rs.next() ? rs.getLong(Constantes.ID) : null;
            }
        });
        if (resultadoQuery != null) {*/
        rowsAffected = jtm.update(SqlQuery.UPDATE_ASIGNATURA_CURSO, asignaturaCurso.getId_asignatura(), asignaturaCurso.getId_curso(), asignaturaCurso.getId());

        /*}

        if (rowsAffected == 0) {
            rowsAffected = -1;
        }
         */
        return rowsAffected;
    }

    public int updateAsignaturasdbUtils(Asignatura asignatura) {
        int filaAsignatura = -1;

        Connection con = null;

        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            filaAsignatura = qr.update(con,
                    SqlQuery.UPDATE_ASIGNATURA,
                    asignatura.getNombre(),
                    asignatura.getId());

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }

        return filaAsignatura;
    }

    public int updateCursodbUtils(Curso curso) {
        int filas = -1;

        Connection con = null;

        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            filas = qr.update(con,
                    SqlQuery.UPDATE_CURSO,
                    curso.getCurso(),
                    curso.getId());

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }

        return filas;
    }

    public int deleteAsignaturaCursodbUtils(String id_asignatura, String id_curso) {
        int filasErased = -1;

        Connection con = null;

        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            filasErased = qr.update(con,
                    SqlQuery.DELETE_ASIGNATURA_CURSO,
                    id_asignatura, id_curso);

        } catch (Exception ex) {
            if (ex.getMessage().contains(ConstantesError.errorForeingkey)) {
                filasErased = ConstantesError.CodeErrorClaveForanea;
            }
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filasErased;
    }

    public int deleteAsignaturadbUtils(String key) {
        int filasErased = -1;

        Connection con = null;

        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            filasErased = qr.update(con,
                    SqlQuery.DELETE_ASIGNATURA,
                    key);

        } catch (Exception ex) {
            if (ex.getMessage().contains(ConstantesError.errorForeingkey)) {
                filasErased = ConstantesError.CodeErrorClaveForanea;
            }
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filasErased;
    }

    public int deleteCursodbUtils(String key) {
        int filasErased = -1;

        Connection con = null;

        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            filasErased = qr.update(con,
                    SqlQuery.DELETE_CURSO,
                    key);

        } catch (Exception ex) {
            if (ex.getMessage().contains(ConstantesError.errorForeingkey)) {
                filasErased = ConstantesError.CodeErrorClaveForanea;
            }
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filasErased;
    }

    @Deprecated
    public boolean deleteAsignaturadbUtilsForce(int key) throws SQLException {
        int filasNota = -1;
        int filasAsigantura = -1;
        boolean borrado = Boolean.FALSE;

        Connection con = null;

        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(Boolean.FALSE);
            QueryRunner qr = new QueryRunner();

            filasNota = qr.update(con,
                    SqlQuery.DELETE_NOTA_ASIGNATURA,
                    key);
            filasAsigantura = qr.update(con,
                    SqlQuery.DELETE_ASIGNATURA,
                    key);

            if (filasNota > 0 && filasAsigantura > 0) {
                borrado = Boolean.TRUE;
                con.commit();
            } else {
                con.rollback();
            }

        } catch (Exception ex) {
            if (con != null) {
                con.rollback();
            }

            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return borrado;
    }

    public List<AsignaturaCurso> getAllAsignaturasdbUtilsNotas() {
        List<AsignaturaCurso> lista = null;

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<AsignaturaCurso>> handler
                    = new BeanListHandler<AsignaturaCurso>(AsignaturaCurso.class);
            lista = qr.query(con, SqlQuery.SELECT_ALL_ASIGNATURAS, handler);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

}//Fin clase
