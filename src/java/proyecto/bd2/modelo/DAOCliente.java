package proyecto.bd2.modelo;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAOCliente {
    public static String status;
    
    public static ArrayList <Cliente> obtenerTodo(){
        Connection con = null;
        ArrayList<Cliente> clientes = null;
        Statement cons = null;
        ResultSet res = null;
        try{
            con = Conexion.conectarse();
            clientes = new ArrayList<>();
            cons = con.createStatement();
            res = cons.executeQuery("SELECT * FROM cliente");
            while(res.next()){
                Integer numeroCliente = res.getInt(1);
                Integer numeroAlmacen = res.getInt(2);
                String nombreCliente = res.getString(3);
                Cliente cliente = new Cliente(numeroCliente, numeroAlmacen, nombreCliente);
                clientes.add(cliente);
            }
            return clientes;
        } catch(Exception e){
            status = "Error: " + e.getMessage();
        } finally{
            try{
                con.close();
                cons.close();
                res.close();
            } catch (Exception e){
                status = "Error: " + e.getMessage();
            }
        }
        return null;
    }
    
    public static void guardar(Cliente cliente){
        Connection con = null;
        CallableStatement guardarCliente = null;
        try{
            con=Conexion.conectarse();
            guardarCliente = con.prepareCall("{call guardar_cliente(?,?,?)}");
            guardarCliente.setInt(1, cliente.getNumeroCliente());
            guardarCliente.setInt(2, cliente.getNumeroAlmacen());
            guardarCliente.setString(3, cliente.getNombreCliente());
            guardarCliente.execute();
            status = "Cliente guardado";
        } catch(Exception e){
            status = "Error: " + e.getMessage();
        } finally{
            try{
                con.close();
                guardarCliente.close();
            } catch (Exception e){
                status = "Error: " + e.getMessage();
            }
        }
    }
    
    public static void actualizar(Cliente cliente){
        Connection con = null;
        CallableStatement actualizarCliente = null;
        try{
            con = Conexion.conectarse();
            actualizarCliente = con.prepareCall("{CALL actualizar_cliente(?,?,?)}");
            actualizarCliente.setInt(1, cliente.getNumeroCliente());
            actualizarCliente.setInt(2, cliente.getNumeroAlmacen());
            actualizarCliente.setString(3, cliente.getNombreCliente());
            actualizarCliente.execute();
            status = "Cliente actualizado";
        } catch(Exception e){
            status = "Error: " + e.getMessage();
        } finally{
            try{
                con.close();
                actualizarCliente.close();
            } catch(Exception e){
                status = "Error: " + e.getMessage();
            }
        }
    }

    public static void eliminar(int id){
        Connection con = null;
        CallableStatement eliminarCliente = null;
        try{
            con = Conexion.conectarse();
            eliminarCliente = con.prepareCall("{call eliminar_cliente(?)}");
            eliminarCliente.setInt(1, id);
            eliminarCliente.execute();
            status = "Cliente eliminado";
        } catch(Exception e){
            status = "Error: " + e.getMessage();
        } finally{
            try{
                con.close();
                eliminarCliente.close();
            } catch(Exception e){
                status = "Error: " + e.getMessage();
            }
        }
    }
}