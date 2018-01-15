/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Nota;
import model.Alumno;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author IvanGarGal
 */
public class InformeAlumnoNotasDAO {

    public List<Nota> verAlumnos(Long idAlu){
        Connection con = null;
        List<Nota> n = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Nota>> h = new BeanListHandler<>(Nota.class);
            n = qr.query(con, "SELECT NOTAS.ID_ALUMNO AS 'IDALUMNO', NOTAS.ID_ASIGNATURA AS 'IDASIGNATURA', ALUMNOS.NOMBRE AS 'ALUMNO', ASIGNATURAS.NOMBRE AS 'ASIGNATURA', NOTAS.NOTA FROM ((NOTAS INNER JOIN ALUMNOS ON NOTAS.ID_ALUMNO = ALUMNOS.ID) INNER JOIN ASIGNATURAS ON NOTAS.ID_ASIGNATURA = ASIGNATURAS.ID) WHERE NOTAS.ID_ALUMNO = ?;", h, idAlu);

        } catch (Exception ex) {
            Logger.getLogger(InformeAlumnoNotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return n;
    }
    
    public List<Alumno> getAllAlumnos(){
        Connection con = null;
        List<Alumno> n = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Alumno>> h = new BeanListHandler<>(Alumno.class);
            n = qr.query(con, "SELECT * FROM ALUMNOS", h);

        } catch (Exception ex) {
            Logger.getLogger(InformeAlumnoNotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return n;
    }
    
    

}//fin clase
