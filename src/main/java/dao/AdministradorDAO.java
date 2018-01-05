/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Administrador;
import utils.Constantes;

/**
 *
 * @author DAW
 */
public class AdministradorDAO {

    public Administrador insertProfessor(Administrador admin) {
          Connection con = null;
        try {/*
            con = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement(Constantes.QUERYINSERTALUMNO , Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, a.getNombre());
            stmt.setDate(2, new java.sql.Date(a.getFecha_nacimiento().getTime()));
            stmt.setBoolean(3, a.getMayor_edad());

            int filas = stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                admin.setId(rs.getInt(1));
            }
*/
        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            DBConnection.getInstance().cerrarConexion(con);
        }

        return admin;
    }
    
}
