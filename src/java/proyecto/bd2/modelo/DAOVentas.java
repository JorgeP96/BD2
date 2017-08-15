package proyecto.bd2.modelo;

import java.sql.*;
import java.util.ArrayList;

public class DAOVentas {
    public static String status;
    
    public static ArrayList <Ventas> obtenerTodo(){
        Connection con = null;
        Statement cons = null;
        ResultSet res = null;
        ArrayList<Ventas> ventas = null;
        try{
            con = Conexion.conectarse();
            ventas = new ArrayList<>();
            cons = con.createStatement();
            res = cons.executeQuery("SELECT * FROM ventas");
            while(res.next()){
                Integer numeroVenta = res.getInt(1);
                Integer numeroCliente = res.getInt(2);
                Integer numeroVendedor = res.getInt(3);
                Float montoVenta = res.getFloat(4);
                Ventas venta = new Ventas(numeroVenta, numeroCliente, numeroVendedor, montoVenta);
                ventas.add(venta);
            }
            return ventas;
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
    
    public static void guardar(Ventas ventas){
        Connection con = null;
        CallableStatement guardarVenta = null;
        try{
            con=Conexion.conectarse();
            guardarVenta = con.prepareCall("{call guardar_ventas(?,?,?,?)}");
            guardarVenta.registerOutParameter(1, java.sql.Types.INTEGER);
            guardarVenta.setInt(2, ventas.getNumeroCliente());
            guardarVenta.setInt(3, ventas.getNumeroVendedor());
            guardarVenta.setFloat(4, ventas.getMontoVenta());
            guardarVenta.execute();
            status = "Venta guardada";
        } catch(Exception e){
            status = "Error: " + e.getMessage();
        } finally{
            try{
                con.close();
                guardarVenta.close();
            } catch (Exception e){
                status = "Error: " + e.getMessage();
            }
        }
    }
    
    public static void actualizar(Ventas ventas){
        Connection con = null;
        CallableStatement actualizarVenta = null;
        try{
            con = Conexion.conectarse();
            actualizarVenta = con.prepareCall("{call actualizar_venta(?,?,?,?)}");
            actualizarVenta.setInt(1, ventas.getIdVentas());
            actualizarVenta.setInt(2, ventas.getNumeroCliente());
            actualizarVenta.setInt(3, ventas.getNumeroVendedor());
            actualizarVenta.setFloat(4, ventas.getMontoVenta());
            actualizarVenta.execute();
            status = "Venta actualizada";
        } catch (Exception e){
            status = "Error: " + e.getMessage();
        } finally{
            try{
                con.close();
                actualizarVenta.close();
            } catch(Exception e){
                status = "Error: " + e.getMessage();
            }
        }
    }

    public static void eliminar(int id){
        Connection con = null;
        CallableStatement eliminarVenta = null;
        try{
            con = Conexion.conectarse();
            eliminarVenta = con.prepareCall("{call eliminar_venta(?)}");
            eliminarVenta.setInt(1, id);
            eliminarVenta.execute();
            status = "Venta eliminada";
        } catch(Exception e){
            status = "Error: " + e.getMessage();
        } finally{
            try{
                con.close();
                eliminarVenta.close();
            } catch(Exception e){
                status = "Error: " + e.getMessage();
            }
        }
    }
}
