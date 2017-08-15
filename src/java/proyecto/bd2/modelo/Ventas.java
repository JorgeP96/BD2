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
public class Ventas {
    private int idVentas;
    private int numeroCliente;
    private int numeroVendedor;
    private float montoVenta;
    
    public Ventas(){
        
    }

    public Ventas(int idVentas, int numeroCliente, int numeroVendedor, float montoVenta) {
        this.idVentas = idVentas;
        this.numeroCliente = numeroCliente;
        this.numeroVendedor = numeroVendedor;
        this.montoVenta = montoVenta;
    }
    
    public Ventas(int numeroCliente, int numeroVendedor, float montoVenta) {
        this.numeroCliente = numeroCliente;
        this.numeroVendedor = numeroVendedor;
        this.montoVenta = montoVenta;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getNumeroVendedor() {
        return numeroVendedor;
    }

    public void setNumeroVendedor(int numeroVendedor) {
        this.numeroVendedor = numeroVendedor;
    }

    public float getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(float montoVenta) {
        this.montoVenta = montoVenta;
    }
    
    
}
