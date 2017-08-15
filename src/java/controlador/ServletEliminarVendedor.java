package controlador;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import proyecto.bd2.modelo.*;

public class ServletEliminarVendedor extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            int numeroVendedor = Integer.parseInt(request.getParameter("numeroVendedorEliminar"));
            DAOVendedor.eliminar(numeroVendedor);
            out.println(DAOVendedor.status);
        } catch (Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
}