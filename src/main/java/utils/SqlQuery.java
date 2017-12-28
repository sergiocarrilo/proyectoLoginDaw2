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
    //SUPERUSER DAO
    public static final String QUERYGETALLUSERS = "SELECT * FROM USERS JOIN USER_PERMISOS WHERE USERS.ID = USER_PERMISOS.ID_USER LIMIT 10 OFFSET ?";
    public static final  String QUERYHACERADMIN = "UPDATE USER_PERMISOS SET ID_PERMISOS = ? WHERE ID_USER = ?";
    
      //ASIGNATURAS DAO
    public static String SELECT_ALL_ASIGNATURAS = "SELECT ASIGNATURAS_CURSOS.ID_ASIGNATURA , ASIGNATURAS_CURSOS.ID_CURSO, ASIGNATURAS.NOMBRE, CURSOS.CURSO FROM ASIGNATURAS,CURSOS,ASIGNATURAS_CURSOS WHERE ASIGNATURAS_CURSOS.ID_ASIGNATURA = ASIGNATURAS.ID AND ASIGNATURAS_CURSOS.ID_CURSO = CURSOS.ID";
    public static String INSERT_ASIGNATURA = "INSERT INTO ASIGNATURAS (ID, NOMBRE) VALUES (NULL, ?)";
    public static String INSERT_CURSO = "INSERT INTO CURSOS (ID, CURSO) VALUES (NULL, ?)";
    public static String UPDATE_ASIGNATURA = "UPDATE ASIGNATURAS SET NOMBRE = ? WHERE ASIGNATURAS.ID = ?";
    public static String UPDATE_CURSO = "UPDATE CURSOS SET CURSO = ? WHERE CURSOS.ID = ?";
    public static String DELETE_ASIGNATURA = "DELETE FROM ASIGNATURAS WHERE ID = ? ";
    public static String DELETE_CURSO = "DELETE FROM CURSOS WHERE ID = ? ";
    public static String DELETE_NOTA_ASIGNATURA = "DELETE FROM NOTAS WHERE ID_ASIGNATURA = ? ";
}
