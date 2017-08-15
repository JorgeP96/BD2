package controlador;

import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import proyecto.bd2.modelo.*;

public class ServletBuscarTodosVenta extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try{
            ArrayList<Ventas> ventas = DAOVentas.obtenerTodo();
            //creamos un objeto de la recien cargada biblioteca GSON
            Gson convertido = new Gson();
            String json = convertido.toJson(ventas);
            out.println(json);
        } catch (Exception e){
            out.println("Erorr: " + e.getMessage());
        }
    }
}
