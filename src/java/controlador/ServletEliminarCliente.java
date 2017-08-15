package controlador;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import proyecto.bd2.modelo.*;

public class ServletEliminarCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            int numeroCliente = Integer.parseInt(request.getParameter("numeroClienteEliminar"));
            DAOCliente.eliminar(numeroCliente);
            out.println(DAOCliente.status);
        } catch (Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
}