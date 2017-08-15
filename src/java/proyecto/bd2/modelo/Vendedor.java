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
public class Vendedor {
    private int numeroVendedor;
    private String nombreVendedor;
    private String areaVentas;
    
    public Vendedor(){
        
    }
    
    public Vendedor(int numeroVendedor, String nombreVendedor, String areaVentas){
        this.numeroVendedor = numeroVendedor;
        this.nombreVendedor = nombreVendedor;
        this.areaVentas = areaVentas;
    }

    public int getNumeroVendedor() {
        return numeroVendedor;
    }

    public void setNumeroVendedor(int numeroVendedor) {
        this.numeroVendedor = numeroVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getAreaVentas() {
        return areaVentas;
    }

    public void setAreaVentas(String areaVentas) {
        this.areaVentas = areaVentas;
    }
    
    
}
