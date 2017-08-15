/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import proyecto.bd2.modelo.Conexion;

/**
 *
 * @author Jorge
 */
public class ServletAutenticar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String login = request.getParameter("login");      
        String password = request.getParameter("password");
        
        try {
            Conexion.autenticarse(login, password);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/bienvenido.jsp");
            dispatcher.forward(request, response);
            
            
        } catch (Exception ex) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
