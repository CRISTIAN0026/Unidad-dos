package Compra_venta_listas;

public class Cliente {

    protected String cédula;
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected String genero;
    protected String fechaNacimiento;
    protected String teléfono;
    protected String email;
    protected String dirección;
    protected String estado;

    public Cliente(String cédula, String nombre, String apellido1, String apellido2, String genero,
            String fechaNacimiento, String teléfono, String email, String dirección, String estado) {
        this.cédula = cédula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.teléfono = teléfono;
        this.email = email;
        this.dirección = dirección;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCédula() {
        return cédula;
    }

    public void setCédula(String cédula) {
        this.cédula = cédula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente [cédula=" + cédula + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
                + apellido2 + ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento + ", teléfono=" + teléfono
                + ", email=" + email + ", dirección=" + dirección + ", estado=" + estado + "]";
    }

}
