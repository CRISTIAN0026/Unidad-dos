package Compra_venta_listas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compra {

    protected static int ultimoConsecutivo = 0;
    protected int consecutivo;
    protected LocalDateTime fecha;
    protected String proveedor;
    protected String códigoProducto;
    protected double precioCompra;
    protected double cantidad;
    protected double valorPagarSinIVA;
    protected double valorIVA;
    protected double valorTotalPagar;

    public Compra(String proveedor, String códigoProducto, double precioCompra,
            double cantidad, double valorPagarSinIVA, double valorIVA, double valorTotalPagar) {
        this.consecutivo = ++ultimoConsecutivo;
        this.fecha = LocalDateTime.now();
        this.proveedor = proveedor;
        this.códigoProducto = códigoProducto;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.valorPagarSinIVA = valorPagarSinIVA;
        this.valorIVA = valorIVA;
        this.valorTotalPagar = valorTotalPagar;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String fechaFormateada = fecha.format(formatter);

        return "Compra [consecutivo=" + consecutivo + ", fecha=" + fechaFormateada + ", proveedor=" + proveedor + ", códigoProducto="
                + códigoProducto + ", precioCompra=" + precioCompra + ", cantidad=" + cantidad + ", valorPagarSinIVA="
                + valorPagarSinIVA + ", valorIVA=" + valorIVA + ", valorTotalPagar=" + valorTotalPagar + "]";
    }

    
}
