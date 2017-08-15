package controlador;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import proyecto.bd2.modelo.*;

public class ServletGuardarCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            int numeroCliente = Integer.parseInt(request.getParameter("numeroClienteGuardar"));
            int numeroAlmacen = Integer.parseInt(request.getParameter("numeroAlmacenGuardar"));
            String nombreCliente = request.getParameter("nombreClienteGuardar");
            Cliente cliente = new Cliente(numeroCliente, numeroAlmacen, nombreCliente);
            DAOCliente.guardar(cliente);
            out.println(DAOCliente.status);
        } catch (Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
}
