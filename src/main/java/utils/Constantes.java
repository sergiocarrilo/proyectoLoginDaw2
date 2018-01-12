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

    public static final String  REGISTRO_TEMPLATE = "registroTemplate.ftl";
    public static final String  ACTION_TEMPLATE = "ACTION";
    public static final String  DEFAULT_ENCODING = "UTF-8";
    public static final String  CONTENT_TYPE = "text/html; charset=UTF-8";

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

    //parametros TareaAlumno
    public static final String ID_TAREAS_ALUMNO = "id_tareas_alumno";
    public static final String HECHO = "hecho";

    //Columnas Cursos
    public static final String CURSO = "CURSO";

    //Mensajes Asignaturas Servlet
    public static final String INSERT_ASIGNATURA = "INSERT_ASIGNATURA";
    public static final String INSERT_CURSO = "INSERT_CURSO";
    public static final String UPDATE_ASIGNATURA = "UPDATE_ASIGNATURA";
    public static final String UPDATE_CURSO = "UPDATE_CURSO";
    public static final String DELETE_ASIGNATURA = "DELETE_ASIGNATURA";
    public static final String DELETE_CURSO = "DELETE_CURSO";
    public static final String  MESSAGE_QUERY_ASIGNATURA_INSERTED = "Asignatura fue insertado en la lista";
    public static final String  MESSAGE_QUERY_ASIGNATURA_INSERT_FAILED = "Asignatura no agregada a la base de datos";
    public static final String  MESSAGE_QUERY_ASIGNATURA_UPDATED = "Asignatura actualizada correctamente";
    public static final String  MESSAGE_QUERY_ASIGNATURA_UPDATE_FAILED = "Error en la actualización de Asignatura";
    public static final String  MESSAGE_QUERY_ASIGNATURA_DELETED = "Asignatura eliminada correctamente";
    public static final String  MESSAGE_QUERY_ASIGNATURA_DELETED_FAIL = "Cuidado! Tienes alumnos que estan cursando esta asignatura. Estás Seguro?";
    public static final String  MESSAGE_QUERY_ASIGNATURA_DELETED_FAILED_AGAIN = "Problemas graves, no pudimos borrar la Asignatura";
    public static final String  ASIGNATURA_RESULT = "asignaturaResult";
    public static final String  RESULTADO_QUERY = "resultado";    
    public static final String  ASIGNATURAS_LIST = "asignaturasList";    
    public static final String  ASIGNATURAS_TEMPLATE = "asignaturasTemplate.ftl";    
    public static final String  LISTA_ASIGNATURAS = "listaAsignaturas";    
    public static final String  LISTA_ASIGNATURA_CURSO = "listaAsignaturaCurso";    
    public static final String  LISTA_CURSOS = "listaCursos";    
    public static final String  MESSAGE_TO_USER = "messageToUser";
    
    //Filtro
    public static final String  MESSAGE_TO_USER_OUT_OF_RANGE = "No tienes Acceso al Contenido";
    //Servlet Profesor - si lo hubiese     
    public static final String  LISTA_PROFESORES = "listaProfesores";

    //Servlet Asignaturas-Profesor     
    public static final String  PROFESOR_ASIGNATURA_TEMPLATE = "profesorAsignaturaTemplate.ftl";    
    public static final String  LISTA_PROFESORES_ASIGNATURAS = "listaProfesoresAsignaturas";    
    public static final String  MESSAGE_QUERY_PROFEASIGNATURA_INSERT_FAILED = "Tenemos problemas agregando esta relación, inténtalo otra vez";    
    public static final String  MESSAGE_QUERY_PROFEASIGNATURA_INSERTED = "Relación agregada correctamente";    
    public static final String  MESSAGE_QUERY_PROFEASIGNATURA_DELETED = "Relación borrada correctamente";    
    public static final String  MESSAGE_QUERY_PROFEASIGNATURA_DELETED_FAIL = "Tenemos problemas borrando esta relación, inténtalo más tarde";

    //modelo Profesor-Asignatura - PLANTILLA
    public static final String  ID_PROFESOR = "id_profesor";

    //Servlet Informe Notas - Asignaturas    
    public static final String  INFORME_NOTAS_ASIGNATURAS = "informeNotasAsignaturas.ftl";    
    public static final String  LISTADO_INFORME_NOTASASIG = "listadoInformeNotasAsig";    
    public static final String  CURSO_SELECCIONADO = "cursoSeleccionado";

    public static final String  LOGIN_ON = "loginOnFromServer";
    public static final String  LEVEL_ACCESS = "levelAccess";

    //parametros  plantilla SuperUser 
    public static final String IDUSER = "iduser";
    public static final String IDPERMISO = "idpermiso";
    public static final String OFFSET = "offset";

    //NotasServlet
    public static final String  NOTASTEMPLATE = "notas.ftl";

    //SuperuserServlet
    public static final String  SUPERUSERTEMPLATE = "superuser.ftl";
    public static final String HACERADMIN = "HACERADMIN";
    public static final String QUITARADMIN = "QUITARADMIN";
    //mensajes superuser
    public static final String  MESSAGEPERMISOCAMBIADO = "Se ha cambiado el permiso del usuario correctamente";
    public static final String  MESSAGEPERMISONOCAMBIADO = "No se ha podido cambiar el permiso del usuario";

    //AdminServlet
    public static final String  ADMINTEMPLATE = "admin.ftl";
    public static final String INSERTARPROFE = "INSERTARPROFESSOR";
    public static final String INSERTARALUMNO = "INSERTARALUMNO";
    public static final String INSERTARASIGNATURA = "INSERTARASIGNATURA";
    public static final String NAME = "name";
    public static final String LISTA = "elementos";
    public static final String FECHA_ENTRADA = "fecha_entrada";
    public static final String FECNA = "fecna";
    public static final String MAYOR = "mayor";
    public static final String VIEWPROFESSOR = "VIEWPROFESSOR";
    public static final String VIEWALUMNO = "VIEWALUMNO";
    public static final String VIEW_ALUMNOS = "VIEW_ALUMNOS";
    public static final String VIEWASIGNATURA = "VIEWASIGNATURA";
    public static final String MESSAGEPROFESORNOINSERTADO = "No se ha podido insertar el profesor";
    public static final String MESSAGEPROFESORINSERTADO = "El profesor se ha insertado correctamente";
    public static final String  PASSWORDPROFESOR = "nohay2sin3";
    public static final String MESSAGEALUMNONOINSERTADO = "No se ha podido insertar el alumno";
    public static final String MESSAGEALUMNOINSERTADO = "El alumno se ha insertado correctamente";
    public static final String MESSAGEASIGNATURANOINSERTADA = "No se ha podido insertar la asignatura";
    public static final String MESSAGEASIGNATURAINSERTADO = "La asignatura se ha insertado correctamente";
    public static final String MESSAGEUSUARIOREPETIDO = "El nombre de usuario esta en uso";
    public static final String PASSWORDALUMNO = "tiernogalvan";
    public static final String PROFESORES = "profe";
    public static final String ALUMNOS = "alumno";
    public static final String ASIGNATURAS = "asignaturas";

    //URL    
    public static final String  BASE_URL_SERVER = "baseUrlServer";

    //servlet Login    
    public static final String  INDEX_TEMPLATE = "index.ftl";    
    public static final String  MESSAGE_USER_LOGIN_FAIL_PASSWORD = "Contraseña Errónea";    
    public static final String  MESSAGE_USER_LOGIN_FAIL_ACTIVO = "Quieto parado! Este Usuario no ha sido validado";    
    public static final String  MESSAGE_USER_LOGIN_FAIL_NOMBRE = "Error en las credenciales, El Usuario no existe";    
    public static final String  MESSAGE_USER_MISSING_FIELDS = "Te faltan campos por rellenar";
    
    //servlet Registro
    public static final String  EMAIL_SUBJECT_VALIDATE = "CRUD: Hola %s - Correo de Activación";    
    public static final String MESSAGE_USER_REGISTER_SUBMIT_EMAIL = "Estás a un paso de completar tu registro, por favor, revisa tu correo";
    public static final String MESSAGE_USER_REGISTER_SUBMIT_EMAIL_FAIL = "Tenemos problemas para enviarte un correo de confirmación";    
    public static final String MESSAGE_USER_EXIST = "Ya tenemos un usuario con un Nombre o Email igual";            
    public static final String MESSAGE_USER_ERROR_INSERT = "Tenemos un problema en el servicio, Intentalo más tarde";    
    public static final String MESSAGE_USER_VALIDATE_EMAIL_FAIL = "Tenemos problemas validando tu Email, enlace de Validación Erróneo, faltan parametros";
    public static final String MESSAGE_USER_VALIDATE_EMAIL_FAIL_ID = "Tenemos problemas validando tu Email, enlace de Validación Erróneo";
    public static final String MESSAGE_USER_VALIDATE_FAIL = "No podemos Validar tu cuenta intentalo más tarde.";
    public static final String MESSAGE_USER_VALIDATE_OK = "Felicidades, Hemos validado tu cuenta.";
    public static final String MESSAGE_USER_VALIDATE_EMAIL_TIME_OUT = "Has sobrepasado el tiempo de validación";

    //Servlet Tareas Alumno        
    public static final String  TAREAS_ALUMNO_TEMPLATE = "tareasAlumnoTemplate.ftl";    
    public static final String  LISTA_TAREAS_ALUMNO = "listaTareasAlumno";    
    public static final String  MESSAGE_TAREA_ALUMNO_UPDATED = "La tarea fue actualizada correctamente";    
    public static final String  MESSAGE_TAREA_ALUMNO_FAIL = "Tenemos problemas Actualizando el estado de la tarea, prueba otra vez";
    //Servlet Notas Alumno
    public static final String  NOTAS_ALUMNO_TEMPLATE = "notasAlumnoTemplate.ftl";    
    public static final String  LISTA_NOTAS_ALUMNO = "listaNotasAlumno";    
    //Servlet Informe Notas Alumnos
    public static final String  IDPROFESOR = "idprofesor";
    public static final String  INFORMEALUMNONOTAS = "informeNotasAlumnos.ftl";
    public static final String VIEWTABLA = "VIEWTABLA";
    public static final String ASIGNATURA = "asignatura";
    public static final String IDASIGNATURA = "idasignatura";
    
    //Servlet tareas profesor
    public static final String TAREASPROFESOR = "tareasProfesor.ftl";
    public static final String MESSAGETAREAPUESTA = "La tarea fue puesta correctamente";
    public static final String MESSAGETAREAFAIL = "No se ha podido añadir la tarea, prueba otra vez";
    public static final String PONERTAREA = "PONERTAREA";
    public static final String FECHA_ENTREGA ="fecha_entrega";
    public static final String TABLATAREAS ="tablatareas";
        
}//fin clase
