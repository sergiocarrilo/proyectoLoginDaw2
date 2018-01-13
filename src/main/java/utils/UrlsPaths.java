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
public class UrlsPaths {

    //Filtros -> para desactivar; Ejemplo: "/secure/super" -> "/Xsecure/super"
    public static final String SECURE_SUPER_PRIVATE = "/secure/super/*";
    public static final String SECURE_PROFE = "/secure/profe/*";
    public static final String SECURE_ALUMNO = "/secure/alumno/*";
    public static final String SECURE_ADMINISTRADOR = "/secure/admin/*";
    //Urls - Servlets
    public static final String ASIGNATURAS = "/secure/admin/asignaturas";
    public static final String NOTAS = "/secure/profe/notas";
    public static final String REGISTRO = "/registro";    
    public static final String PROFESOR_ASIGNATURAS = "/secure/admin/profesor-asignaturas";
    public static final String INFORME_NOTAS_ASIGNATURAS = "/secure/admin/informe-notas-asignaturas";
    public static final String INFORME_ALUMNO_NOTAS = "/secure/admin/informe-alumno-notas";
    public static final String INFORME_NOTAS_ALUMNOS = "/secure/profe/informe-notas-alumnos";
    public static final String INDEX = "/index";
    public static final String ADMINISTRADOR = "/secure/admin/administrador";
    public static final String SUPERUSER = "/secure/super/superuser";
    public static final String TAREAS_ALUMNO = "/secure/alumno/tareas-alumno";
    public static final String NOTAS_ALUMNO = "/secure/alumno/notas";
    public static final String TAREAS_PROFESOR = "/secure/profe/tareas-profesor";

}//fin clase
