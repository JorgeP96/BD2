package controlador;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import proyecto.bd2.modelo.*;

public class ServletEliminarVenta extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            int numeroVenta = Integer.parseInt(request.getParameter("numeroVentaEliminar"));
            DAOVentas.eliminar(numeroVenta);
            out.println(DAOVentas.status);
        } catch (Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
}