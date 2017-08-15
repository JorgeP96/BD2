/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bd2.modelo;

/**
 *
 * @author Jorge
 */
public class Cliente {
    private int numeroCliente;
    private int numeroAlmacen;
    private String nombreCliente;
    
    public Cliente(){
        
    }
    
    public Cliente(int numCliente, int numAlmacen, String nomCliente){
        this.numeroCliente = numCliente;
        this.numeroAlmacen = numAlmacen;
        this.nombreCliente = nomCliente;
    }
    
    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getNumeroAlmacen() {
        return numeroAlmacen;
    }

    public void setNumeroAlmacen(int numeroAlmacen) {
        this.numeroAlmacen = numeroAlmacen;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
