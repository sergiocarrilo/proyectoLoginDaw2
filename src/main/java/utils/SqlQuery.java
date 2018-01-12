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
    public static final String QUERYGETALLUSERS = "SELECT * FROM USERS LEFT JOIN USER_PERMISOS ON USERS.ID = USER_PERMISOS.ID_USER where ID_PERMISOS in (2) OR ID_PERMISOS IS null  LIMIT 10  OFFSET ?";
    public static final String QUERYHACERADMIN = "INSERT INTO USER_PERMISOS (ID_USER_PERMISO,ID_USER,ID_PERMISOS) VALUES (NULL,?,2);";
    public static final String QUERYQUITARADMIN = "DELETE FROM USER_PERMISOS WHERE ID_PERMISOS = 2 AND ID_USER = ?";

    //ADMIN DAO
    public static final String QUERYINSERTUSER = "INSERT INTO USERS(ID,NOMBRE,PASSWORD,EMAIL,CODIGO_ACTIVACION,FECHA_ACTIVACION,ACTIVO) VALUES(null,?,?,?,' ',?,1)";
    public static final String QUERYPERMISOPROFESOR = "INSERT INTO USER_PERMISOS (ID_USER_PERMISO ,ID_USER ,ID_PERMISOS) VALUES (NULL,?,3)";
    public static final String QUERYINSERTPROFESOR = "INSERT INTO PROFESORES (ID,NOMBRE,FECHA_NACIMIENTO,FECHA_ENTRADA) VALUES (?,?,?,?)";
    public static final String QUERYINSERTALUMNO = "INSERT INTO ALUMNOS (ID,NOMBRE,FECHA_NACIMIENTO,MAYOR_EDAD,FECHA_ENTRADA) VALUES (?,?,?,?,?)";
    public static final String QUERYPERMISOALUMNO = "INSERT INTO USER_PERMISOS (ID_USER_PERMISO ,ID_USER ,ID_PERMISOS) VALUES (NULL,?,4)";

    public static final String QUERYGETALLPROFESSORS = "SELECT * FROM PROFESORES LIMIT 10  OFFSET ?";
    public static final String QUERYGETALLALUMNOS = "SELECT * FROM ALUMNOS LIMIT 10  OFFSET ?";
    public static final String QUERYGETALLASIGNATURAS = "SELECT * FROM ASIGNATURAS LIMIT 10  OFFSET ?";
    public static final String QUERYCOMPUSER = "SELECT ID FROM USERS WHERE NOMBRE = ?";
    public static final String QUERYCOMPCORREO = "SELECT ID FROM USERS WHERE EMAIL = ?";
    //USER DAO
    public static String SELECT_USER_BY_NAME = "SELECT * FROM USERS WHERE NOMBRE = ?";
    public static String SELECT_ID_PERMISO_BY_ID_USER = "SELECT ID_PERMISOS FROM USER_PERMISOS WHERE ID_USER = ?";
    public static String SELECT_USER_BY_EMAIL = "SELECT * FROM USERS WHERE EMAIL = ?";
    public static String SELECT_USER_BY_NAME_EMAIL_CODIGO_ACTIVACION = "SELECT * FROM USERS WHERE NOMBRE = ? AND EMAIL = ? AND CODIGO_ACTIVACION = ?";
    public static String UPDATE_USER_ACTIVO_ON = "UPDATE USERS SET ACTIVO = 1 WHERE ID = ?";

    //ASIGNATURAS DAO
    public static String SELECT_ALL_ASIGNATURAS_CURSOS = "SELECT ASIGNATURAS_CURSOS.ID ,ASIGNATURAS_CURSOS.ID_ASIGNATURA , ASIGNATURAS_CURSOS.ID_CURSO, ASIGNATURAS.NOMBRE, CURSOS.CURSO "
            + "FROM ASIGNATURAS,CURSOS,ASIGNATURAS_CURSOS WHERE ASIGNATURAS_CURSOS.ID_ASIGNATURA = ASIGNATURAS.ID AND ASIGNATURAS_CURSOS.ID_CURSO = CURSOS.ID LIMIT 10  OFFSET ?";
    public static String SELECT_ALL_ASIGNATURAS = "SELECT * FROM ASIGNATURAS";
    public static String SELECT_ALL_ASIGNATURA_CURSO_BY_ID_ASIGNATURA_AND_ID_CURSO = "SELECT ASIGNATURAS_CURSOS.ID,ASIGNATURAS_CURSOS.ID_ASIGNATURA,ASIGNATURAS_CURSOS.ID_CURSO \n"
            + "FROM ASIGNATURAS_CURSOS\n"
            + "WHERE ID_ASIGNATURA = ? AND ID_CURSO = ?";
    public static String SELECT_ALL_CURSOS = "SELECT * FROM CURSOS";
    public static String INSERT_ASIGNATURA_CURSO = "INSERT INTO ASIGNATURAS_CURSOS (ID, ID_ASIGNATURA, ID_CURSO) VALUES (NULL, ? , ? );";
    public static String INSERT_ASIGNATURA = "INSERT INTO ASIGNATURAS (ID, NOMBRE) VALUES (NULL, ?)";
    public static String INSERT_CURSO = "INSERT INTO CURSOS (ID, CURSO) VALUES (NULL, ?)";
    public static String UPDATE_ASIGNATURA_CURSO = "UPDATE ASIGNATURAS_CURSOS SET ID_ASIGNATURA = ? , ID_CURSO = ? WHERE ASIGNATURAS_CURSOS.ID = ?";
    public static String UPDATE_ASIGNATURA = "UPDATE ASIGNATURAS SET NOMBRE = ? WHERE ASIGNATURAS.ID = ?";
    public static String UPDATE_CURSO = "UPDATE CURSOS SET CURSO = ? WHERE CURSOS.ID = ?";
    public static String DELETE_ASIGNATURA_CURSO = "DELETE FROM ASIGNATURAS_CURSOS WHERE ASIGNATURAS_CURSOS.ID_ASIGNATURA = ? AND ASIGNATURAS_CURSOS.ID_CURSO = ?";
    public static String DELETE_ASIGNATURA = "DELETE FROM ASIGNATURAS WHERE ID = ? ";
    public static String DELETE_CURSO = "DELETE FROM CURSOS WHERE ID = ? ";
    public static String DELETE_NOTA_ASIGNATURA = "DELETE FROM NOTAS WHERE ID_ASIGNATURA = ? ";

    //NOTAS DAO
    public static String QUERYGETALLNOTAS_BY_ID_ASIGNATURA = "SELECT NOTAS.ID_ALUMNO, ALUMNOS.NOMBRE, NOTAS.ID_ASIGNATURA, ASIGNATURAS.NOMBRE, NOTAS.NOTA \n"
            + "FROM ((NOTAS INNER JOIN ALUMNOS ON NOTAS.ID_ALUMNO = ALUMNOS.ID) INNER JOIN ASIGNATURAS ON NOTAS.ID_ASIGNATURA = ASIGNATURAS.ID) \n"
            + "WHERE NOTAS.ID_ASIGNATURA = ?\n"
            + "LIMIT 10 OFFSET ?";
    public static String SELECT_ALL_ASIGNATURAS_BY_ID_PROFESOR = "SELECT PROFES_ASIGNATURAS.ID,PROFES_ASIGNATURAS.ID_ASIGNATURA,ASIGNATURAS.NOMBRE AS 'NOMBRE_ASIGNATURA'\n"
            + "FROM PROFES_ASIGNATURAS,ASIGNATURAS,PROFESORES\n"
            + "WHERE PROFES_ASIGNATURAS.ID_PROFE = PROFESORES.ID AND PROFES_ASIGNATURAS.ID_ASIGNATURA = ASIGNATURAS.ID AND PROFES_ASIGNATURAS.ID_PROFE = ?";
    public static String SELECT_ALL_ALUMNOS_BY_ID_ASIGNATURA = "SELECT ALUMNOS.ID,ALUMNOS.NOMBRE \n"
            + "FROM ALUMNOS_ASIGNATURAS,ALUMNOS\n"
            + "WHERE ALUMNOS_ASIGNATURAS.ID_ALUMNO = ALUMNOS.ID AND ALUMNOS_ASIGNATURAS.ID_ASIGNATURA = ?";

    //Asignaturas - Profesores
    public static String SELECT_ALL_PROFESORES = "SELECT PROFESORES.ID, PROFESORES.NOMBRE FROM PROFESORES";
    public static String SELECT_ALL_PROFES_ASIGNATURAS_BY_ID_PROFE_AND_ID_ASIGNATURA = "SELECT PROFES_ASIGNATURAS.ID,PROFES_ASIGNATURAS.ID_PROFE,PROFES_ASIGNATURAS.ID_ASIGNATURA "
            + "FROM PROFES_ASIGNATURAS "
            + "WHERE ID_PROFE = ? AND ID_ASIGNATURA = ?";
    public static String SELECT_ALL_PROFESORES_ASIGNATURAS = "SELECT PROFES_ASIGNATURAS.ID,PROFES_ASIGNATURAS.ID_PROFE,PROFES_ASIGNATURAS.ID_ASIGNATURA, USERS.NOMBRE AS 'NOMBRE_PROFE', ASIGNATURAS.NOMBRE AS 'NOMBRE_ASIGNATURA' "
            + "FROM PROFES_ASIGNATURAS,USERS,ASIGNATURAS WHERE PROFES_ASIGNATURAS.ID_PROFE = USERS.ID AND PROFES_ASIGNATURAS.ID_ASIGNATURA = ASIGNATURAS.ID  LIMIT 10 OFFSET ?";
    public static String INSERT_PROFESOR_ASIGNATURA = "INSERT INTO PROFES_ASIGNATURAS (ID, ID_PROFE, ID_ASIGNATURA) VALUES (NULL, ?, ?)";
    public static String DELETE_PROFESOR_ASIGNATURA = "DELETE FROM PROFES_ASIGNATURAS WHERE PROFES_ASIGNATURAS.ID = ?";

    //Profesores
    public static String SELECT_PROFESORES_BY_ID_CURSO = "SELECT PROFES_ASIGNATURAS.ID_PROFE AS 'ID', USERS.NOMBRE \n"
            + "FROM PROFES_ASIGNATURAS,ASIGNATURAS,ASIGNATURAS_CURSOS,USERS\n"
            + "WHERE PROFES_ASIGNATURAS.ID_ASIGNATURA = ASIGNATURAS.ID AND ASIGNATURAS.ID = ASIGNATURAS_CURSOS.ID_ASIGNATURA AND PROFES_ASIGNATURAS.ID_PROFE = USERS.ID "
            + "AND ASIGNATURAS_CURSOS.ID_CURSO = ?";
    public static String SELECT_PROFESORES_BY_ID_CURSO_AND_ID_ASIG = "SELECT PROFES_ASIGNATURAS.ID_PROFE AS 'ID', USERS.NOMBRE \n"
            + "FROM PROFES_ASIGNATURAS,ASIGNATURAS,ASIGNATURAS_CURSOS,USERS\n"
            + "WHERE PROFES_ASIGNATURAS.ID_ASIGNATURA = ASIGNATURAS.ID AND ASIGNATURAS.ID = ASIGNATURAS_CURSOS.ID_ASIGNATURA AND PROFES_ASIGNATURAS.ID_PROFE = USERS.ID"
            + " AND ASIGNATURAS_CURSOS.ID_CURSO = ? AND ASIGNATURAS.ID = ?";
    //Informe 1 curso, notas - asignatura - profesor
    public static String SELECT_ALL_ASIGNATURAS_BY_ID_CURSO = "SELECT ASIGNATURAS.ID, ASIGNATURAS.NOMBRE \n"
            + "FROM ASIGNATURAS_CURSOS,ASIGNATURAS\n"
            + "WHERE  ASIGNATURAS_CURSOS.ID_ASIGNATURA = ASIGNATURAS.ID   AND ASIGNATURAS_CURSOS.ID_CURSO = ?";
    public static String SELECT_NOTAS_BY_ID_CURSO_AND_ID_ASIG = "SELECT  ALUMNOS.ID AS 'ID_ALUMNO',ALUMNOS.NOMBRE AS 'NOMBRE_ALUMNO',NOTAS.NOTA\n"
            + "FROM ASIGNATURAS_CURSOS,ASIGNATURAS,NOTAS,ALUMNOS\n"
            + "WHERE  ASIGNATURAS_CURSOS.ID_ASIGNATURA = ASIGNATURAS.ID AND ASIGNATURAS.ID = NOTAS.ID_ASIGNATURA AND ALUMNOS.ID = NOTAS.ID_ALUMNO  AND"
            + " ASIGNATURAS_CURSOS.ID_CURSO = ? AND ASIGNATURAS_CURSOS.ID_ASIGNATURA = ?";
    //Informe Notas de alumno en concreto
    public static String QUERYGETALLNOTAS_BY_ID_ALUMNO = "SELECT NOTAS.ID_ALUMNO, ALUMNOS.NOMBRE, NOTAS.ID_ASIGNATURA, ASIGNATURAS.NOMBRE, NOTAS.NOTA \n"
            + "FROM ((NOTAS INNER JOIN ALUMNOS ON NOTAS.ID_ALUMNO = ALUMNOS.ID) INNER JOIN ASIGNATURAS ON NOTAS.ID_ASIGNATURA = ASIGNATURAS.ID) \n"
            + "WHERE NOTAS.ID_ALUMNO = ?";
    //TAREAS
    public static String SELECT_ALL_TAREAS_BY_ID_USER = "SELECT TAREAS_ALUMNOS.ID_TAREAS_ALUMNOS, ASIGNATURAS.ID AS 'ID_ASIGNATURA',TAREAS.ID_TAREA,ASIGNATURAS.NOMBRE,TAREAS.NOMBRE AS 'TAREA',TAREAS.FECHA_ENTREGA,TAREAS_ALUMNOS.HECHO \n"
            + "FROM ALUMNOS_ASIGNATURAS,TAREAS_ALUMNOS,TAREAS,ASIGNATURAS\n"
            + "WHERE ALUMNOS_ASIGNATURAS.ID_ALUMNO = TAREAS_ALUMNOS.ID_ALUMNO AND TAREAS.ID_TAREA = TAREAS_ALUMNOS.ID_TAREA AND ASIGNATURAS.ID = TAREAS.ID_ASIGNATURA "
            + "AND TAREAS_ALUMNOS.ID_ALUMNO =  ?";
    public static String UPDATE_TAREA_BY_ID_TAREAS_ALUMNOS = "UPDATE TAREAS_ALUMNOS SET HECHO = ? WHERE TAREAS_ALUMNOS.ID_TAREAS_ALUMNOS = ?";
    //NOTAS ALUMNO
    public static String SELECT_NOTAS_ALUMNO_BY_ID_ALUMNO = "SELECT NOTAS.ID_ASIGNATURA AS \"IDASIGNATURA\",ASIGNATURAS.NOMBRE AS \"ASIGNATURA\",NOTAS.NOTA \n"
            + "FROM  NOTAS,ASIGNATURAS\n"
            + "WHERE NOTAS.ID_ASIGNATURA = ASIGNATURAS.ID AND ID_ALUMNO = ?";
    public static String INSERTUSER = "INSERT";

    //INFROME NOTAS ALUMNOS DAO
    public static String QUERYASIGNATURASPROFE = "SELECT * FROM ASIGNATURAS INNER JOIN PROFES_ASIGNATURAS WHERE PROFES_ASIGNATURAS.ID_ASIGNATURA=ASIGNATURAS.ID AND PROFES_ASIGNATURAS.ID_PROFE = ?";
    public static String QUERYGETNOTASASIOGNATURA = "SELECT * FROM ALUMNOS INNER JOIN NOTAS WHERE NOTAS.ID_ALUMNO = ALUMNOS.ID AND NOTAS.ID_ASIGNATURA = ?";

    //TAREASPROFESOR  DAO
    public static String QUERYINSERTTAREA = "INSERT INTO TAREAS (ID_TAREA,ID_ASIGNATURA,NOMBRE,FECHA_ENTREGA) VALUES (null,?,?,?);";
}
