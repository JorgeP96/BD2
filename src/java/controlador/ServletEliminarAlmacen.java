package controlador;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import proyecto.bd2.modelo.*;

public class ServletEliminarAlmacen extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            int numeroAlmacen = Integer.parseInt(request.getParameter("numeroAlmacenEliminar"));
            DAOAlmacen.eliminar(numeroAlmacen);
            out.println(DAOAlmacen.status);
        } catch (Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
}