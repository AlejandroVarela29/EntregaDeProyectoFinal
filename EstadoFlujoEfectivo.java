import java.util.Arrays;
import java.util.Scanner;

public class EstadoFlujoEfectivo {
    static Scanner leer = new Scanner(System.in);
    static final int intentosMaximos = 3;

    public static void main(String[] args) {
        int numCuentas = obtenerEntero("Ingrese el número de cuentas: ");
        String[] cuentas = new String[numCuentas];
        double[] ingresos = new double[numCuentas];
        double[] egresos = new double[numCuentas];

        for (int i = 0; i < numCuentas; i++) {
            System.out.println("cuenta #" + (i + 1));
            cuentas[i] = obtenerCadena("Nombre de la cuenta: ");
            ingresos[i] = obtenerDouble("Ingresos para la cuenta: ");
            egresos[i] = obtenerDouble("Egresos para la cuenta: ");
        }

        Arrays.sort(cuentas);

        FlujoEfectivo flujoEfectivo = new FlujoEfectivo(cuentas, ingresos, egresos);

        System.out.println("\nFlujo de efectivo neto: $" + flujoEfectivo.calcularFlujoEfectivoNeto());
    }

    private static int obtenerEntero(String nota) {
        int intentos = 0;
        while (intentos < intentosMaximos) {
            try {
                System.out.print(nota);
                return Integer.parseInt(leer.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un valor logico");
                intentos++;
            }
        }
        throw new RuntimeException("Se agotaron el numero de intentos .");
    }

    private static double obtenerDouble(String nota) {
        int intentos = 0;
        while (intentos < intentosMaximos) {
            try {
                System.out.print(nota);
                return Double.parseDouble(leer.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ingrese un valor logico");
                intentos++;
            }
        }
        throw new RuntimeException("Se han agotado tus intentos");
    }

    private static String obtenerCadena(String nota) {
        int intentos = 0;
        while (intentos < intentosMaximos) {
            System.out.print(nota);
            String input = leer.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("ingrese un valor logico");
                intentos++;
            }
        }
        throw new RuntimeException("Se han agotado tus intentos ");
    }
}