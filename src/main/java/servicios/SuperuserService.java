/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.SuperuserDAO;
import model.Superuser;
import java.util.List;


/**
 *
 * @author DAW
 */
public class SuperuserService {
    public List<Superuser> getAllUsers()
    {
        SuperuserDAO dao = new SuperuserDAO();
        
        return dao.getAllUsersJDBCTemplate();
    }
}
