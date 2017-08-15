package controlador;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import proyecto.bd2.modelo.*;

public class ServletGuardarAlmacen extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            int numeroAlmacen = Integer.parseInt(request.getParameter("numero"));
            String ubicacionAlmacen = request.getParameter("ubicacion");
            Almacen almacen = new Almacen(numeroAlmacen, ubicacionAlmacen);
            DAOAlmacen.guardar(almacen);
            out.println(DAOAlmacen.status);
        } catch (Exception e){
            out.println("Erorr: " + e.getMessage());
        }
    }
}

