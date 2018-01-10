/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Nota;
import model.Asignatura;
import model.Alumno;
import model.ProfesorAsignatura;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.Constantes;
import utils.SqlQuery;

public class NotasDAO {

    public Nota guardarNota(Nota n) {
        Connection con = null;
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            filas = qr.update(con, "UPDATE NOTAS SET NOTA = ? WHERE ID_ALUMNO = ? AND ID_ASIGNATURA = ?", n.getNota(), n.getIdAlumno(), n.getIdAsignatura());

            if (filas == 0) {
                con.setAutoCommit(false);
                Long id = qr.insert(con,
                        "INSERT INTO NOTAS (ID_ALUMNO,ID_ASIGNATURA,NOTA) VALUES(?,?,?)",
                        new ScalarHandler<Long>(), n.getIdAlumno(), n.getIdAsignatura(), n.getNota());
                con.commit();
            }
        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
            n = null;
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return n;
    }

    public int delNota(Nota n) {
        Connection con = null;
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            filas = qr.update(con, "DELETE FROM NOTAS WHERE ID_ALUMNO = ? AND ID_ASIGNATURA = ?", n.getIdAlumno(), n.getIdAsignatura());

        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filas;
    }

    public Nota getNota(Long idAlu, Long idAsig) {
        Connection con = null;
        Nota n = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<Nota> h = new BeanHandler<>(Nota.class);
            n = qr.query(con, "SELECT * FROM NOTAS WHERE ID_ALUMNO = ? AND ID_ASIGNATURA = ?", h, idAlu, idAsig);

        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return n;
    }
    
    public List<Nota> getAllNotas(int offset) {
        List<Nota> lista = new ArrayList<>();
        Nota nota = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DBConnection.getInstance().getConnection();
            stmt = con.prepareStatement(SqlQuery.QUERYGETALLNOTAS, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, offset);
            rs = stmt.executeQuery();


            while (rs.next()) {
                //Retrieve by column name
                int idAlumno = rs.getInt("NOTAS.ID_ALUMNO");
                int idAsignatura = rs.getInt("NOTAS.ID_ASIGNATURA");
                String alumno = rs.getString("ALUMNOS.NOMBRE");
                String asignatura = rs.getString("ASIGNATURAS.NOMBRE");
                int notita = rs.getInt("NOTAS.NOTA");
                nota = new Nota();
                nota.setIdAlumno((long)idAlumno);
                nota.setIdAsignatura((long)idAsignatura);
                nota.setAlumno(alumno);
                nota.setAsignatura(asignatura);
                nota.setNota(notita);

                lista.add(nota);
            }

        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }   
}//FIN CLASE