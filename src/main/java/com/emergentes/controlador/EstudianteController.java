/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.dao.EstudianteDAO;
import com.emergentes.dao.EstudianteDAOImpl;
import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jhomara
 */
public class EstudianteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Estudiante est = new Estudiante();
            EstudianteDAO dao = new EstudianteDAOImpl();
            int id;
            
            String accion = (request.getParameter("action") != null)? request.getParameter("action"): "view";
            switch(accion){
                case "add":
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    // aviso controller action = edit &id + 3
                    id = Integer.parseInt(request.getParameter("id"));
                    try {
                        // obtener el objecto  que corresponde al registro
                        est = dao.getById(id);
                    } catch (Exception ex) {
                        System.out.println("Error al obtener el registro " + ex.getMessage());
                    }
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    
                    break;
                    
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    try {
                        dao.delete(id);
                    } catch (Exception ex) {
                        System.out.println("Error al eliminar el registro " + ex.getMessage());
                    }
                    response.sendRedirect("EstudianteController");
                    break;
                    
                case "view":
                    
                    List<Estudiante> lista = new ArrayList<Estudiante>();
                    try {
                        lista = dao.getAll();
                    } catch (Exception ex) {
                        System.out.println("Error al listar " + ex.getMessage());
                    }
                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
                    
                    break;
                    
                default:
                    break;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al operar: " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre =request.getParameter("nombre");
            String apellido =request.getParameter("apellido");
            String seminario =request.getParameter("seminario");
            String confirmado =request.getParameter("confirmado");
            String fecha =request.getParameter("fecha");

            Estudiante est = new Estudiante();
            est.setId(id);
            est.setNombre(nombre);
            est.setApellido(apellido);
            est.setSeminario(seminario);
            est.setConfirmado(confirmado);
            est.setFecha(fecha);
            
            EstudianteDAO dao = new EstudianteDAOImpl();
            if(id == 0){
                try {
                    // nuevo
                    dao.insert(est);
                } catch (Exception ex) {
                    System.out.println("Error al insertar el registro " + ex.getMessage());
                }
                
            }else{
                try {
                    //edit
                    dao.update(est);
                } catch (Exception ex) {
                    System.out.println("Error al actualizar el registro " + ex.getMessage());
                }
            }
            
            response.sendRedirect("EstudianteController");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
