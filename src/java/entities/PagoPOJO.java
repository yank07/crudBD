
package entities;


public class PagoPOJO {
    private int id;
    private VentaPOJO venta;
    private int forma_pago;
    private int cuotas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VentaPOJO getVenta() {
        return venta;
    }

    public void setVenta(VentaPOJO venta) {
        this.venta = venta;
    }

    public int getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(int forma_pago) {
        this.forma_pago = forma_pago;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }
    
}
