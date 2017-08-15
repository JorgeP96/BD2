package proyecto.bd2.modelo;

public class Almacen {
    private int numeroAlmacen;
    private String ubicacionAlmacen;
    
    public Almacen(){
        
    }
    
    public Almacen(int numeroAlmacen, String ubicacionAlmacen){
        this.numeroAlmacen = numeroAlmacen;
        this.ubicacionAlmacen = ubicacionAlmacen;
    }
    
    public int getNumeroAlmacen() {
        return numeroAlmacen;
    }

    public void setNumeroAlmacen(int numeroAlmacen) {
        this.numeroAlmacen = numeroAlmacen;
    }

    public String getUbicacionAlmacen() {
        return ubicacionAlmacen;
    }

    public void setUbicacionAlmacen(String ubicacionAlmacen) {
        this.ubicacionAlmacen = ubicacionAlmacen;
    }
}
