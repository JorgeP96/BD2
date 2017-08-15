package controlador;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import proyecto.bd2.modelo.*;

public class ServletActualizarCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            int numeroCliente = Integer.parseInt(request.getParameter("numeroClienteActualizar"));
            int numeroAlmacen = Integer.parseInt(request.getParameter("numeroAlmacenClienteActualizar"));
            String nombreCliente = request.getParameter("nombreClienteActualizar");
            Cliente cliente = new Cliente(numeroCliente, numeroAlmacen, nombreCliente);
            DAOCliente.actualizar(cliente);
            out.println(DAOCliente.status);
        } catch (Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
}