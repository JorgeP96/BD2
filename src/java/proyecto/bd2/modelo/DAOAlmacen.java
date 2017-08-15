package proyecto.bd2.modelo;

import java.sql.*;
import java.util.ArrayList;

public class DAOAlmacen {
    public static String status;
    
    public static ArrayList <Almacen> obtenerTodo(){
        Connection con = null;
        Statement cons = null;
        ResultSet res = null;
        ArrayList<Almacen> almacenes = null;
        try{
            con = Conexion.conectarse();
            almacenes = new ArrayList<>();
            cons = con.createStatement();
            res = cons.executeQuery("SELECT * FROM ALMACEN");
            while(res.next()){
                Integer numeroAlmacen = res.getInt(1);
                String ubicacionAlmacen = res.getString(2);
                Almacen almacen = new Almacen(numeroAlmacen, ubicacionAlmacen);
                almacenes.add(almacen);
            }
            return almacenes;
        } catch(Exception e) {
            status = "Error: " + e.getMessage();
        } finally {
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
    
    public static void guardar(Almacen almacen){
        Connection con = null;
        CallableStatement guardarAlmacen = null;
        try{
            con=Conexion.conectarse();
            guardarAlmacen = con.prepareCall("{call guardar_almacen(?,?)}");
            guardarAlmacen.setInt(1, almacen.getNumeroAlmacen());
            guardarAlmacen.setString(2,almacen.getUbicacionAlmacen());
            guardarAlmacen.execute();
            status = "Almacen guardado";
        } catch (Exception e){
            status = "Error1: " + e.getMessage();
        } finally {
            try{
                con.close();
                guardarAlmacen.close();
            } catch (Exception e){
                status = "Error2: " + e.getMessage();
            }
        }
    }
    
    public static void actualizar(Almacen almacen){
        Connection con = null;
        CallableStatement actualizarAlmacen = null;
        try{
            con = Conexion.conectarse();
            actualizarAlmacen = con.prepareCall("{CALL actualizar_almacen(?,?)}");
            actualizarAlmacen.setInt(1, almacen.getNumeroAlmacen());
            actualizarAlmacen.setString(2, almacen.getUbicacionAlmacen());
            actualizarAlmacen.execute();
            status = "Almacen actualizado";
        } catch(Exception e){
            status = "Error: " + e.getMessage();
        } finally{
            try{
                con.close();
                actualizarAlmacen.close();
            } catch(Exception e){
                status = "Error: " + e.getMessage();
            }
        }
    }
    
    public static void eliminar(int id){
        Connection con = null;
        CallableStatement eliminarAlmacen = null;
        try{
            con = Conexion.conectarse();
            eliminarAlmacen = con.prepareCall("{call eliminar_almacen(?)}");
            eliminarAlmacen.setInt(1, id);
            eliminarAlmacen.execute();
            status = "Almacen eliminado";
        } catch(Exception e){
            status = "Error: " + e.getMessage();
        } finally{
            try{
                con.close();
                eliminarAlmacen.close();
            } catch(Exception e){
                status = "Error: " + e.getMessage();
            }
        }
    }
}
