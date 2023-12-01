import java.util.Arrays;
import java.util.Scanner;
public class EstadoResultados {
    static Scanner leer = new Scanner(System.in);
    static final int intentosMaximos = 3;
    String nombreusuario;

    public static void main(String[] args) {
        String nombreusuario = leer.nextLine();
        System.out.println("Bienvenid@ " +nombreusuario+ " ,A continuacion Te presentaremos El estado de resultado de Tu negocio , conforme los productos que has adquirido y vendido:");
        int numProductos = obtenerEntero("Ingrese el número de productos: ");
        Producto[] productos = new Producto[numProductos];

        for (int i = 0; i < numProductos; i++) {
            System.out.println("Producto #" + (i + 1));
            String nombre = obtenerCadena("Nombre del producto: ");
            double costo = obtenerDouble("Costo del producto: ");
            int cantidadVendida = obtenerEntero("Cantidad Vendida: ");

            productos[i] = new Producto(nombre, costo, cantidadVendida);
        }

        Arrays.sort(productos, (producto1, producto2) -> producto1.nombre.compareTo(producto2.nombre));

        EstadoFinanciero estadoFinanciero = new EstadoFinanciero(productos);

        System.out.println("Sus Ingresos totales son : $" + estadoFinanciero.calcularIngresosTotales());
        System.out.println("Sus Costos totales son: $" + estadoFinanciero.calcularCostosTotales());
        System.out.println("la Utilidad es de : $" + estadoFinanciero.calcularUtilidad());
    }

    private static int obtenerEntero(String Nota) {
        int intentos = 0;
        while (intentos < intentosMaximos) {
            try {
                System.out.print(Nota);
                return Integer.parseInt(leer.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un valor entero válido.");
                intentos++;
            }
        }
        throw new RuntimeException("Número de intentos agotado.");
    }

    private static double obtenerDouble(String Nota) {
        int intentos = 0;
        while (intentos < intentosMaximos) {
            try {
                System.out.print(Nota);
                return Double.parseDouble(leer.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un valor logico");
                intentos++;
            }
        }
        throw new RuntimeException("Número de intentos agotado.");
    }

    private static String obtenerCadena(String Nota) {
        int intentos = 0;
        while (intentos < intentosMaximos) {
            System.out.print(Nota);
            String input = leer.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Ingrese un valor logico.");
                intentos++;
            }
        }
        throw new RuntimeException ("Se han agotado los intentos ");
    }
}