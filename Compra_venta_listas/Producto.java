package Compra_venta_listas;

public class Producto {

    protected String código;
    protected String nombre;
    protected String marca;
    protected String color;
    protected double precioCompra;
    protected double precioVenta;
    protected double descuentoMáximo;
    protected double unidadesExistencia;
    protected String métricaMedida;
    protected String categoría;

    public Producto(String código, String nombre, String marca, String color, double precioCompra,
            double descuentoMáximo, double unidadesExistencia, String métricaMedida, String categoría) {
        this.código = código;
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
        this.precioCompra = precioCompra;
        this.precioVenta = (precioCompra * 0.4) + precioCompra;
        this.descuentoMáximo = descuentoMáximo;
        this.unidadesExistencia = unidadesExistencia;
        this.métricaMedida = métricaMedida;
        this.categoría = categoría;
    }

    public String getCódigo() {
        return código;
    }

    public void setCódigo(String código) {
        this.código = código;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getUnidadesExistencia() {
        return unidadesExistencia;
    }

    public void setUnidadesExistencia(double unidadesExistencia) {
        this.unidadesExistencia = unidadesExistencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        this.categoría = categoría;
    }

    public double getDescuentoMáximo() {
        return descuentoMáximo;
    }

    public void setDescuentoMáximo(double descuentoMáximo) {
        this.descuentoMáximo = descuentoMáximo;
    }

    @Override
    public String toString() {
        return "Producto [código=" + código + ", nombre=" + nombre + ", marca=" + marca + ", color=" + color
                + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", descuentoMáximo="
                + descuentoMáximo + ", unidadesExistencia=" + unidadesExistencia + ", métricaMedida=" + métricaMedida
                + ", categoría=" + categoría + "]";
    }

}
