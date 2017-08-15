package proyecto.bd2.modelo;

import java.sql.*;
import java.util.ArrayList;

public class DAOVendedor {
    public static String status;
    
    public static ArrayList <Vendedor> obtenerTodo(){
        Connection con = null;
        ArrayList<Vendedor> vendedores = null;
        Statement cons = null;
        ResultSet res = null;
        try{
            con = Conexion.conectarse();
            vendedores = new ArrayList<>();
            cons = con.createStatement();
            res = cons.executeQuery("SELECT * FROM vendedor");
            while(res.next()){
                Integer numeroVendedor = res.getInt(1);
                String nombreVendedor = res.getString(2);
                String areaVendedor = res.getString(3);
                Vendedor vendedor = new Vendedor(numeroVendedor, nombreVendedor, areaVendedor);
                vendedores.add(vendedor);
            }
            return vendedores;
        } catch (Exception e){
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
    
    public static void guardar(Vendedor vendedor){
        Connection con = null;
        CallableStatement guardarVendedor = null;
        try{
            con=Conexion.conectarse();
            guardarVendedor = con.prepareCall("{call guardar_vendedor(?,?,?)}");
            guardarVendedor.setInt(1, vendedor.getNumeroVendedor());
            guardarVendedor.setString(2, vendedor.getNombreVendedor());
            guardarVendedor.setString(3, vendedor.getAreaVentas());
            guardarVendedor.execute();
            status = "Vendedor guardado";
        } catch (Exception e){
            status = "Error: " + e.getMessage();
        } finally{
            try{
                con.close();
                guardarVendedor.close();
            } catch (Exception e){
                status = "Error: " + e.getMessage();
            }
        }
    }
    
    public static void actualizar(Vendedor vendedor){
        Connection con = null;
        CallableStatement actualizarVendedor = null;
        try{
            con = Conexion.conectarse();
            actualizarVendedor = con.prepareCall("{CALL actualizar_vendedor(?,?,?)}");
            actualizarVendedor.setInt(1, vendedor.getNumeroVendedor());
            actualizarVendedor.setString(2, vendedor.getNombreVendedor());
            actualizarVendedor.setString(3, vendedor.getAreaVentas());
            actualizarVendedor.execute();
            status = "Vendedor actualizado";
        } catch(Exception e){
            status = "Error: " + e.getMessage();
        } finally{
            try{
                con.close();
                actualizarVendedor.close();
            } catch(Exception e){
                status = "Error: " + e.getMessage();
            }
        }
    }

    public static void eliminar(int id){
        Connection con = null;
        CallableStatement eliminarVendedor = null;
        try{
            con = Conexion.conectarse();
            eliminarVendedor = con.prepareCall("{call eliminar_vendedor(?)}");
            eliminarVendedor.setInt(1, id);
            eliminarVendedor.execute();
            status = "Vendedor eliminado";
        } catch(Exception e){
            status = "Error: " + e.getMessage();
        } finally{
            try{
                con.close();
                eliminarVendedor.close();
            } catch(Exception e){
                status = "Error: " + e.getMessage();
            }
        }
    }
}
