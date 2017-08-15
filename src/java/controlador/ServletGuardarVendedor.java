package controlador;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import proyecto.bd2.modelo.*;

public class ServletGuardarVendedor extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            int numeroVendedor = Integer.parseInt(request.getParameter("numeroVendedorGuardar"));
            String nombreVendedor = request.getParameter("nombreVendedorGuardar");
            String areaVentas = request.getParameter("areaVentasGuardar");
            Vendedor vendedor = new Vendedor(numeroVendedor, nombreVendedor, areaVentas);
            DAOVendedor.guardar(vendedor);
            out.println(DAOVendedor.status);
        } catch (Exception e){
            out.println("Erorr: " + e.getMessage());
        }
    }
}