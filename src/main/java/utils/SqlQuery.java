/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author daw
 */
public class SqlQuery {

    public static final String QUERYGETALLUSERS = "SELECT * FROM USERS JOIN USER_PERMISOS WHERE USERS.ID = USER_PERMISOS.ID_USER;";
    public static final  String QUERYHACERADMIN = "UPDATE USER_PERMISOS SET ID_PERMISOS = ? WHERE ID_USER = ?";
}
