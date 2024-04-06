package Compra_venta_listas;

import java.time.LocalDateTime;
import java.util.List;

class Venta {
    protected int consecutivo;
    protected LocalDateTime fecha;
    protected String cédulaCliente;
    protected List<Integer> cantidadesProductos;
    protected String medioPago;
    protected String modalidad;
    protected List<String> códigosProductos;
    protected double valorCobrarSinIVA;
    protected double valorDescuento;
    protected double valorIVA;
    protected String estado;
    protected String motivo;
    protected double valorTotalCobrar;

    public Venta(int consecutivo, String cédulaCliente, String medioPago, String modalidad,
            List<String> códigosProductos, List<Integer> cantidadesProductos, double valorCobrarSinIVA,
            double valorDescuento, double valorIVA,
            double valorTotalCobrar) {
        this.consecutivo = consecutivo;
        this.fecha = LocalDateTime.now();
        this.cédulaCliente = cédulaCliente;
        this.medioPago = medioPago;
        this.modalidad = modalidad;
        this.estado = null;
        this.motivo = null;
        this.códigosProductos = códigosProductos;
        this.valorCobrarSinIVA = valorCobrarSinIVA;
        this.valorDescuento = valorDescuento;
        this.valorIVA = valorIVA;
        this.valorTotalCobrar = valorTotalCobrar;
        this.cantidadesProductos = cantidadesProductos;
    }

    public String getCédulaCliente() {
        return cédulaCliente;
    }

    public void setCédulaCliente(String cédulaCliente) {
        this.cédulaCliente = cédulaCliente;
    }

    public List<Integer> getCantidadesProductos() {
        return cantidadesProductos;
    }

    public void setCantidadesProductos(List<Integer> cantidadesProductos) {
        this.cantidadesProductos = cantidadesProductos;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public List<String> getCódigosProductos() {
        return códigosProductos;
    }

    public void setCódigosProductos(List<String> códigosProductos) {
        this.códigosProductos = códigosProductos;
    }

    public double getValorTotalCobrar() {
        return valorTotalCobrar;
    }

    public void setValorTotalCobrar(double valorTotalCobrar) {
        this.valorTotalCobrar = valorTotalCobrar;
    }

    public double getValorCobrarSinIVA() {
        return valorCobrarSinIVA;
    }

    public void setValorCobrarSinIVA(double valorCobrarSinIVA) {
        this.valorCobrarSinIVA = valorCobrarSinIVA;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public double getValorIVA() {
        return valorIVA;
    }

    public void setValorIVA(double valorIVA) {
        this.valorIVA = valorIVA;
    }

    @Override
    public String toString() {
        return "Venta [consecutivo=" + consecutivo + ", fecha=" + fecha + ", cédulaCliente=" + cédulaCliente
                + ", cantidadesProductos=" + cantidadesProductos + ", medioPago=" + medioPago + ", modalidad="
                + modalidad + ", códigosProductos=" + códigosProductos + ", valorCobrarSinIVA=" + valorCobrarSinIVA
                + ", valorDescuento=" + valorDescuento + ", valorIVA=" + valorIVA + ", estado=" + estado + ", motivo="
                + motivo + ", valorTotalCobrar=" + valorTotalCobrar + "]";
    }

    public String getCodigoProducto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCodigoProducto'");
    }

}