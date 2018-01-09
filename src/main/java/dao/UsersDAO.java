/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import utils.Constantes;
import utils.SqlQuery;

/**
 *
 * @author Gato
 */
public class UsersDAO {

    public UsersDAO() {
    }

    /**
     * Busca un registro por nombre, si existe devuelve el objeto User
     *
     * @param usuario
     * @return usuario
     */
    public User getLoginUserJDBCTemplate(User usuario) {

        JdbcTemplate jtm = new JdbcTemplate(
                DBConnection.getInstance().getDataSource());
        User user = null;

        String resultadoQuery = jtm.query(SqlQuery.SELECT_USER_BY_NAME, new Object[]{usuario.getNombre()}, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet rs) throws SQLException, DataAccessException {
                return rs.next() ? rs.getString(Constantes.NOMBRE) : null;
            }
        });

        if (resultadoQuery != null) {
            user = (User) jtm.queryForObject(SqlQuery.SELECT_USER_BY_NAME, new Object[]{usuario.getNombre()},//funciona siempre que exista un dato en la base de datos
                    new BeanPropertyRowMapper(User.class));
        }

        return user;
    }

    public Long getIdPermisoUserJDBCTemplate(long id_usuario) {

        JdbcTemplate jtm = new JdbcTemplate(
                DBConnection.getInstance().getDataSource());

        Long id_permiso = jtm.query(SqlQuery.SELECT_ID_PERMISO_BY_ID_USER, new Object[]{id_usuario}, new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
                return rs.next() ? rs.getLong(Constantes.ID_PERMISO) : null;
            }
        });
    id_permiso = (long)4;//TODO borrar más tarde
        return id_permiso;
    }
}//fin class
