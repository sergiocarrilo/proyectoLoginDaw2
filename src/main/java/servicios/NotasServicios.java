/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.NotasDAO;
import model.Nota;
import java.util.List;
import java.util.Map;
import utils.Constantes;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

public class NotasServicios {
    public Nota guardarNota(Nota n){
        NotasDAO dao = new NotasDAO();
        return dao.guardarNota(n);
    }
    
    public Nota getNota(Long idalu, Long idasig){
        NotasDAO dao = new NotasDAO();
        return dao.getNota(idalu, idasig);
    }
    
    public Nota getAlumnoNota(Long idalu, Long idasig){
        NotasDAO dao = new NotasDAO();
        return dao.getNota(idalu, idasig);
    }
    
    public int delNota(Nota n){
        NotasDAO dao = new NotasDAO();
        return dao.delNota(n);
    }
    
    public List<Nota> getAllNotas(int offset)
    {
        NotasDAO notas = new NotasDAO();
        return notas.getAllNotas(offset);
    }
    
}
