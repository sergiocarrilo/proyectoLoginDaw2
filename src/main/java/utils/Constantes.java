/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author oscar
 */
public class Constantes {

    public static String registroJSP = "registroJsp.jsp";
    public static String actionTemplate = "ACTION";

    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    public static final String VIEW = "VIEW";
    public static final String DELETE_FORCE = "DELETE_FORCE";
    public static final String REGISTRAR = "REGISTRAR";
    public static final String VALIDATE = "VALIDATE";
    public static final String LOGIN = "LOGIN";
    public static final String LOGOUT = "LOGOUT";

    //Columnas Users
    public static final String USERS = "USERS";
    public static final String ID = "ID";
    public static final String NOMBRE = "NOMBRE";
    public static final String PASSWORD = "PASSWORD";
    public static final String ACTIVO = "ACTIVO";
    public static final String CODIGO_ACTIVACION = "CODIGO_ACTIVACION";
    public static final String FECHA_ACTIVACION = "FECHA_ACTIVACION";
    public static final String EMAIL = "EMAIL";

    //Columnas USER_PERMISOS
    public static final String ID_USER_PERMISO = "ID_USER_PERMISO";
    public static final String ID_USER = "ID_USER";
    public static final String ID_PERMISO = "ID_PERMISOS";

    //Columnas PERMISOS
    //public static final String ID = "ID";
    public static final String DESCRIPCION = "DESCRIPCION";
    //Columnas Asignaturas - CURSOS
    public static final String ID_ASIGNATURA = "ID_ASIGNATURA";
    public static final String ID_CURSO = "ID_CURSO";

    //Columnas Cursos
    public static final String CURSO = "CURSO";

    //Mensajes Asignaturas Servlet
    public static final String INSERT_ASIGNATURA = "INSERT_ASIGNATURA";
    public static final String INSERT_CURSO = "INSERT_CURSO";
    public static final String UPDATE_ASIGNATURA = "UPDATE_ASIGNATURA";
    public static final String UPDATE_CURSO = "UPDATE_CURSO";
    public static final String DELETE_ASIGNATURA = "DELETE_ASIGNATURA";
    public static final String DELETE_CURSO = "DELETE_CURSO";
    public static String messageQueryAsignaturaInserted = "Asignatura fue insertado en la lista";
    public static String messageQueryAsignaturaInsertFailed = "Asignatura no agregada a la base de datos";
    public static String messageQueryAsignaturaUpdated = "Asignatura actualizada correctamente";
    public static String messageQueryAsignaturaUpdateFailed = "Error en la actualización de Asignatura";
    public static String messageQueryAsignaturaDeleted = "Asignatura eliminada correctamente";
    public static String messageQueryAsignaturaDeletedFail = "Cuidado! Tienes alumnos que estan cursando esta asignatura. Estás Seguro?";
    public static String messageQueryAsignaturaDeletedFailedAgain = "Problemas graves, no pudimos borrar la Asignatura";
    public static String asignaturaResult = "asignaturaResult";
    public static String resultadoQuery = "resultado";
    public static String asignaturasList = "asignaturasList";
    public static String asignaturasTemplate = "asignaturasTemplate.ftl";
    public static String listaAsignaturas = "listaAsignaturas";
    public static String listaAsignaturaCurso = "listaAsignaturaCurso";
    public static String listaCursos = "listaCursos";
    public static String messageToUser = "messageToUser";

    //Servlet Profesor - si lo hubiese 
    public static String listaProfesores = "listaProfesores";

    //Servlet Asignaturas-Profesor 
    public static String ProfesorAsignaturaTemplate = "profesorAsignaturaTemplate.ftl";
    public static String listaProfesoresAsignaturas = "listaProfesoresAsignaturas";
    public static String messageQueryProfeAsignaturaInsertFailed = "Tenemos problemas agregando esta relación, inténtalo otra vez";
    public static String messageQueryProfeAsignaturaInserted = "Relación agregada correctamente";
    public static String messageQueryProfesorAsignaturaDeleted = "Relación borrada correctamente";
    public static String messageQueryProfesorAsignaturaDeletedFail = "Tenemos problemas borrando esta relación, inténtalo más tarde";

    //modelo Profesor-Asignatura - PLANTILLA
    public static String ID_PROFESOR = "id_profesor";

    //Servlet Informe Notas - Asignaturas
    public static String InformeNotasAsignaturas = "informeNotasAsignaturas.ftl";
    public static String ListadoInformeNotasAsig = "listadoInformeNotasAsig";
    public static String CursoSeleccionado = "cursoSeleccionado";

    public static String LOGIN_ON = "loginOnFromServer";

    //parametros  plantilla SuperUser 
    public static final String IDUSER = "iduser";
    public static final String IDPERMISO = "idpermiso";
    public static final String OFFSET = "offset";

    //SuperuserServlet
    public static String SUPERUSERTEMPLATE = "superuser.ftl";
    public static final String HACERADMIN = "HACERADMIN";
    //mensajes superuser
    public static String MESSAGEPERMISOCAMBIADO = "Se ha cambiado el permiso del usuario correctamente";
    public static String MESSAGEPERMISONOCAMBIADO = "No se ha podido cambiar el permiso del usuario";

    //AdminServlet
    public static String ADMINTEMPLATE = "admin.ftl";
    public static final String INSERTARPROFE = "INSERTARPROFE";
    public static final String INSERTARALUMNO = "INSERTARALUMNO";
    public static final String INSERTARASIGNATURA = "INSERTARASIGNATURA";
    public static final String NAME = "name";
    // public static final String EMAIL = "email";
    public static final String FECNA = "fecna";
    public static final String MAYOR = "mayor";
    public static final String MESSAGEPROFESORNOINSERTADO = "No se ha podido insertar el profesor";
    public static final String MESSAGEPROFESORINSERTADO = "El profesor se ha insertado correctamente";
    public static String PASSWORDPROFESOR = "nohay2sin3";

    //URL
    public static String BaseUrlServer = "baseUrlServer";
    
    //servlet Login
    public static String IndexTemplate = "index.ftl";
    
}//fin clase
