/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uanl.fcfm.lmad.papw.servlet;

import edu.uanl.fcfm.lmad.papw.dao.UsuarioDao;
import edu.uanl.fcfm.lmad.papw.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alberto
 */
@WebServlet(name = "RegistroUsuarioServlet", urlPatterns = {"/RegistroUsuario"})
public class RegistroUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            Usuario u = new Usuario();
            u.setNickname(request.getParameter("nickname"));
            u.setContrasenia(request.getParameter("contrasenia"));
            u.setCorreoElectronico(request.getParameter("correoElectronico"));
            u.setNombre(request.getParameter("nombre"));
            u.setApellidoPaterno(request.getParameter("apellidoPaterno"));
            u.setApellidoMaterno(request.getParameter("apellidoMaterno"));
            u.setFechaNacimiento(request.getParameter("fechaNacimiento"));
            u.setSexo(request.getParameter("sexo"));
            u.setTelefono(request.getParameter("telefono"));
            u.setImagen(null);
            
            RequestDispatcher disp;
            
            String message;
            if (UsuarioDao.insertar(u) == true)
            {
                message = "Usuario registrado con éxito.";
                request.setAttribute("message", message);
                disp = getServletContext()
                        .getRequestDispatcher("/index.jsp");
                disp.forward(request, response);
            }
            else
            {
                message = "Usuario existente.";
                request.setAttribute("message", message);
                disp = getServletContext()
                        .getRequestDispatcher("/signup.jsp");
                disp.forward(request, response);
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
