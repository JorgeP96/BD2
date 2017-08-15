package controlador;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import proyecto.bd2.modelo.*;

public class ServletActualizarVenta extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            int numeroVenta = Integer.parseInt(request.getParameter("numeroVentaActualizar"));
            int numeroCliente = Integer.parseInt(request.getParameter("numeroClienteVentaActualizar"));
            int numeroVendedor = Integer.parseInt(request.getParameter("numeroVendedorVentaActualizar"));
            float montoVenta = Float.parseFloat(request.getParameter("montoVentaActualizar"));
            Ventas venta = new Ventas(numeroVenta, numeroCliente, numeroVendedor, montoVenta);
            DAOVentas.actualizar(venta);   
            out.println(DAOVentas.status);
        } catch (Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
}