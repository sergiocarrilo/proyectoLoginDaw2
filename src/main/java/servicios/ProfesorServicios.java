/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.ProfesoresDAO;
import java.util.List;
import model.Profesor;

/**
 *
 * @author Gato
 */
public class ProfesorServicios {

    public ProfesorServicios() {
    }

    public List<Profesor> getAllProfesores() {
        ProfesoresDAO dao = new ProfesoresDAO();
        return dao.getAllProfesoresdbUtils();
    }

}//fin clase
