package controlador;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import proyecto.bd2.modelo.*;

public class ServletActualizarVendedor extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            int numeroVendedor = Integer.parseInt(request.getParameter("numeroVendedorActualizar"));
            String nombreVendedor = request.getParameter("nombreVendedorActualizar");
            String areaVentas = request.getParameter("areaVentasActualizar");
            Vendedor vendedor = new Vendedor(numeroVendedor, nombreVendedor, areaVentas);
            DAOVendedor.actualizar(vendedor);
            out.println(DAOVendedor.status);
        } catch (Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
}
