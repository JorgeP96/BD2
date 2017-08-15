package controlador;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import proyecto.bd2.modelo.*;

public class ServletGuardarVenta extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            int numeroCliente = Integer.parseInt(request.getParameter("numeroClienteVentaGuardar"));
            int numeroVendedor = Integer.parseInt(request.getParameter("numeroVendedorVentaGuardar"));
            float montoVenta = Float.parseFloat(request.getParameter("montoVentaGuardar"));
            Ventas venta = new Ventas(numeroCliente,numeroVendedor, montoVenta);
            DAOVentas.guardar(venta);
            out.println(DAOVentas.status);
        } catch (Exception e){
            out.println("Erorr: " + e.getMessage());
        }
    }
}
