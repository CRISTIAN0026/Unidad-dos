package Compra_venta_listas;

import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

public class Main {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();
        List<Compra> compras = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Venta> ventas = new ArrayList<>();

        crearProducto(productos, compras, "001", "Manzanas",
                "Apple", "Rojo", 1000, 10, 4,
                "kg", "Frutas");

        crearProducto(productos, compras, "002", "Peras", "Apple", "Verde",
                800, 15, 4, "kg", "Frutas");

        crearProducto(productos, compras, "001", "Manzanas",
                "Apple", "Rojo", 1500, 10,
                4,
                "kg", "Frutas");

        crearProducto(productos, compras, "003", "Leche", "Alpina", "Blanco", 2000, 5, 1, "litros",
                "Lácteos");
        crearProducto(productos, compras, "004", "Queso", "Alpina", "Amarillo", 5000, 20, 2, "kg",
                "Lácteos");
        crearProducto(productos, compras, "005", "Pan", "Alpina", "Marrón", 500, 10, 10, "unidades",
                "Panadería");

        clientes.add(new Cliente("305678", "Juan", "Pérez", "Gómez", "Masculino", "01-01-1980", "1234567890",
                "juan.perez@gmail.com", "Calle 123", "VIP"));
        clientes.add(new Cliente("9956789", "María", "Rodríguez", "López", "Femenino", "02-02-1981", "2345678901",
                "maria.rodriguez@gmail.com", "Calle 234", "Referido"));
        clientes.add(new Cliente("15467890", "Carlos", "González", "Martínez", "Masculino", "03-03-1982", "3456789012",
                "carlos.gonzalez@gmail.com", "Calle 345", "VIP"));
        clientes.add(new Cliente("11078901", "Ana", "Hernández", "Torres", "Femenino", "04-04-1983", "4567890123",
                "ana.hernandez@gmail.com", "Calle 456", "Referido"));
        clientes.add(new Cliente("2289012", "Luis", "Ramírez", "Morales", "Masculino", "05-05-1984", "5678901234",
                "luis.ramirez@gmail.com", "Calle 567", "VIP"));

        List<SimpleEntry<Producto, Integer>> productosVendidos1 = new ArrayList<>();
        productosVendidos1.add(new SimpleEntry<>(buscarProducto(productos, "001"), 2));
        registrarVenta(ventas, clientes.get(1), "Efectivo", "Directa", productosVendidos1);

        List<SimpleEntry<Producto, Integer>> productosVendidos2 = new ArrayList<>();
        productosVendidos2.add(new SimpleEntry<>(buscarProducto(productos, "001"), 1));
        productosVendidos2.add(new SimpleEntry<>(buscarProducto(productos, "002"), 3));
        registrarVenta(ventas, clientes.get(1), "Tarjeta de crédito", "Domicilio", productosVendidos2);

        List<SimpleEntry<Producto, Integer>> productosVendidos3 = new ArrayList<>();
        productosVendidos3.add(new SimpleEntry<>(buscarProducto(productos, "003"), 2));
        registrarVenta(ventas, clientes.get(3), "Efectivo", "Directa", productosVendidos1);

        System.out.println("\nClientes\n");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }

        System.out.println("\nLos productos\n");
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }

        System.out.println("\nLas compras\n");
        for (Compra compra : compras) {
            System.out.println(compra.toString());
        }

        publicarProductos(productos);

        enviarInformación(productos, clientes);

        actualizarEstadoVenta(ventas, 1, true, "", clientes);
        actualizarEstadoVenta(ventas, 2, false, "El cliente canceló la compra.", clientes);

        actualizarInventario(productos, ventas);

        System.out.println("\nLas ventas\n");
        for (Venta venta : ventas) {
            System.out.println(venta.toString());
        }

        System.out.println("\nLos productos, mostrando sólo aquellos cuya existencia es inferior a 5 unidades\n");
        for (Producto producto : productos) {
            if (producto.getUnidadesExistencia() < 5) {
                System.out.println(producto.toString());
            }
        }

        System.out.println("\nDescuentos\n");
        ofrecerDescuento(ventas, clientes);

        System.out.println("\nBalance financiero\n");
        calcularBalanceFinanciero(productos, ventas);

        System.out.println("\nAjuste de precios\n");
        ajustarPrecios(productos, ventas);
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }
    }

    public static Producto buscarProducto(List<Producto> productos, String código) {
        for (Producto producto : productos) {
            if (producto.getCódigo().equals(código)) {
                return producto;
            }
        }
        return null;
    }

    public static void crearProducto(List<Producto> productos, List<Compra> compras, String código, String nombre,
            String marca, String color,
            double precioCompra, double descuentoMáximo, double unidadesExistencia,
            String métricaMedida, String categoría) {

        Producto producto = buscarProducto(productos, código);

        if (producto == null) {
            producto = new Producto(código, nombre, marca, color, precioCompra, descuentoMáximo,
                    unidadesExistencia, métricaMedida, categoría);
            productos.add(producto);
            crearCompra(compras, "Nueva EPS", producto, 4);
        } else {

            producto.setPrecioCompra(precioCompra);
            producto.setPrecioVenta((precioCompra * 0.4) + precioCompra);
            producto.setUnidadesExistencia(producto.getUnidadesExistencia() + unidadesExistencia);

            crearCompra(compras, "Nueva EPS", producto, 4);
        }
    }

    public static void publicarProductos(List<Producto> productos) {
        List<Producto> productosEnExistencia = new ArrayList<Producto>();

        for (Producto producto : productos) {
            if (producto.getUnidadesExistencia() > 0) {
                productosEnExistencia.add(producto);
            }
        }

        System.out.println("\nProductos ordenados alfabéticamente y agrupados, por categorías\n");
        for (int i = 0; i < productosEnExistencia.size(); i++) {
            for (int j = i + 1; j < productosEnExistencia.size(); j++) {
                if (productosEnExistencia.get(i).getNombre().compareTo(productosEnExistencia.get(j).getNombre()) > 0) {
                    Producto temp = productosEnExistencia.get(i);
                    productosEnExistencia.set(i, productosEnExistencia.get(j));
                    productosEnExistencia.set(j, temp);
                }
            }
        }

        List<List<Producto>> productosPorCategoría = new ArrayList<>();
        List<String> categorías = new ArrayList<>();

        for (Producto producto : productosEnExistencia) {
            String categoría = producto.getCategoría();
            if (!categorías.contains(categoría)) {
                categorías.add(categoría);
                productosPorCategoría.add(new ArrayList<>());
            }
            int index = categorías.indexOf(categoría);
            productosPorCategoría.get(index).add(producto);
        }

        for (int i = 0; i < categorías.size(); i++) {
            System.out.println("Categoría: " + categorías.get(i));
            for (Producto producto : productosPorCategoría.get(i)) {
                System.out.println(producto);
            }
        }

        System.out.println("\nSe ha enviado los productos\n");
    }

    public static void enviarInformación(List<Producto> productos, List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println("Enviando información a " + cliente.getNombre() + "...");
            for (Producto producto : productos) {
                if (producto.getUnidadesExistencia() > 0) {
                    String mensaje = "Producto: " + producto.getNombre() + ", Precio: " + producto.getPrecioVenta()
                            + ", Unidades disponibles: " + producto.getUnidadesExistencia();
                    System.out.println("Mensaje: " + mensaje);

                }
            }
        }
    }

    public static void crearCompra(List<Compra> compras, String proveedor, Producto producto, double cantidad) {
        double precioCompra = producto.getPrecioCompra();
        double valorPagarSinIVA = precioCompra * cantidad;
        double valorIVA = valorPagarSinIVA * 0.19;
        double valorTotalPagar = valorPagarSinIVA + valorIVA;

        Compra compra = new Compra(proveedor, producto.getCódigo(), precioCompra, cantidad, valorPagarSinIVA, valorIVA,
                valorTotalPagar);
        compras.add(compra);
    }

    public static void registrarVenta(List<Venta> ventas, Cliente cliente, String medioPago, String modalidad,
            List<SimpleEntry<Producto, Integer>> productosComprados) {
        int consecutivo = ventas.size() + 1;
        double valorCobrarSinIVA = 0;
        double valorDescuento = 0;
        double valorIVA = 0;

        List<String> códigosProductos = new ArrayList<>();
        List<Integer> cantidadesProductos = new ArrayList<>();
        for (SimpleEntry<Producto, Integer> par : productosComprados) {
            Producto producto = par.getKey();
            Integer cantidad = par.getValue();
            códigosProductos.add(producto.getCódigo());
            cantidadesProductos.add(cantidad);
            double precioVenta = producto.getPrecioVenta();
            double descuento = precioVenta * producto.getDescuentoMáximo() / 100;
            valorCobrarSinIVA += precioVenta * cantidad;
            valorDescuento += descuento * cantidad;
            valorIVA += (precioVenta - descuento) * cantidad * 0.19;
        }

        double valorTotalCobrar = valorCobrarSinIVA - valorDescuento + valorIVA;

        Venta venta = new Venta(consecutivo, cliente.getCédula(), medioPago, modalidad, códigosProductos,
                cantidadesProductos,
                valorCobrarSinIVA, valorDescuento, valorIVA, valorTotalCobrar);
        ventas.add(venta);
    }

    public static Cliente buscarCliente(List<Cliente> clientes, String cédula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCédula().equals(cédula)) {
                return cliente;
            }
        }
        return null;
    }

    public static void actualizarEstadoVenta(List<Venta> ventas, int consecutivo, boolean ventaRealizada,
            String motivo, List<Cliente> clientes) {
        for (Venta venta : ventas) {
            if (venta.getConsecutivo() == consecutivo) {
                if (ventaRealizada) {
                    Cliente cliente = buscarCliente(clientes, venta.getCédulaCliente());
                    venta.setEstado("Éxito");
                    cliente.setEstado("VIP");
                    System.out.println("\ncliente actualizado: " + cliente.getEstado());
                } else {
                    venta.setEstado("Cancelada");
                    venta.setMotivo(motivo);
                }
                break;
            }
        }
    }

    public static void actualizarInventario(List<Producto> productos, List<Venta> ventas) {
        for (Venta venta : ventas) {
            for (int i = 0; i < venta.getCódigosProductos().size(); i++) {
                String códigoProductoVendido = venta.getCódigosProductos().get(i);
                int cantidadVendida = venta.getCantidadesProductos().get(i);
                for (Producto producto : productos) {
                    if (producto.getCódigo().equals(códigoProductoVendido)) {
                        double nuevasUnidades = producto.getUnidadesExistencia() - cantidadVendida;
                        producto.setUnidadesExistencia(nuevasUnidades);
                        break;
                    }
                }
            }
        }
    }

    public static void ofrecerDescuento(List<Venta> ventas, List<Cliente> clientes) {
        int totalVentas = ventas.size();
        double promedioCompras = totalVentas / (double) ventas.size();

        List<String> clientesCompradores = new ArrayList<>();
        List<Integer> comprasPorCliente = new ArrayList<>();
        for (Venta venta : ventas) {
            String cédulaCliente = venta.getCédulaCliente();
            int index = clientesCompradores.indexOf(cédulaCliente);
            if (index == -1) {
                clientesCompradores.add(cédulaCliente);
                comprasPorCliente.add(1);
            } else {
                comprasPorCliente.set(index, comprasPorCliente.get(index) + 1);
            }
        }

        for (int i = 0; i < clientesCompradores.size(); i++) {
            if (comprasPorCliente.get(i) > promedioCompras) {
                System.out.println("El cliente con cédula " + clientesCompradores.get(i)
                        + " tiene un 10% de descuento en la próxima venta.");
            } else if (comprasPorCliente.get(i) < promedioCompras) {
                System.out.println("El cliente con cédula " + clientesCompradores.get(i)
                        + " tiene un 15% de descuento en la próxima compra.");
            }
        }

        for (Cliente cliente : clientes) {
            if (!clientesCompradores.contains(cliente.getCédula())) {
                System.out.println("El cliente con cédula " + cliente.getCédula()
                        + " tiene un 25% de descuento en su primera compra.");
            }
        }
    }

    public static void calcularBalanceFinanciero(List<Producto> productos, List<Venta> ventas) {
        double totalInvertido = 0;
        double totalRecuperado = 0;
        double totalGanancia = 0;
        double totalDescuento = 0;
        double totalIVA = 0;

        for (Producto producto : productos) {
            totalInvertido += producto.getPrecioCompra() * producto.getUnidadesExistencia();
        }

        for (Venta venta : ventas) {
            totalRecuperado += venta.getValorCobrarSinIVA();
            totalGanancia += venta.getValorTotalCobrar() - venta.getValorCobrarSinIVA();
            totalDescuento += venta.getValorDescuento();
            totalIVA += venta.getValorIVA();
        }

        System.out.println("Total invertido en productos: " + totalInvertido);
        System.out.println("Total recuperado en ventas: " + totalRecuperado);
        System.out.println("Total de ganancia: " + totalGanancia);
        System.out.println("Total de descuento generado: " + totalDescuento);
        System.out.println("Total de IVA pagado: " + totalIVA);
    }

    public static void ajustarPrecios(List<Producto> productos, List<Venta> ventas) {
        // Calcular el total de ventas
        int totalVentas = ventas.size();

        // Crear una lista para los productos y otra para contar sus ventas
        List<String> productosVendidos = new ArrayList<>();
        List<Integer> ventasPorProducto = new ArrayList<>();
        for (Venta venta : ventas) {
            for (int i = 0; i < venta.getCódigosProductos().size(); i++) {
                String códigoProductoVendido = venta.getCódigosProductos().get(i);
                int index = productosVendidos.indexOf(códigoProductoVendido);
                if (index == -1) {
                    // Si el producto no está en la lista, lo añadimos
                    productosVendidos.add(códigoProductoVendido);
                    ventasPorProducto.add(venta.getCantidadesProductos().get(i));
                } else {
                    // Si el producto ya está en la lista, incrementamos su conteo de ventas
                    ventasPorProducto.set(index, ventasPorProducto.get(index) + venta.getCantidadesProductos().get(i));
                }
            }
        }

        // Recorrer las listas para ajustar los precios de los productos
        for (int i = 0; i < productosVendidos.size(); i++) {
            if ((ventasPorProducto.get(i) / (double) totalVentas) * 100 < 70) {
                for (Producto producto : productos) {
                    if (producto.getCódigo().equals(productosVendidos.get(i))) {
                        double nuevoPrecio = producto.getPrecioVenta() * 0.65; // Aplicar un descuento del 35%
                        producto.setPrecioVenta(nuevoPrecio);
                        break;
                    }
                }
            }
        }
    }

}
