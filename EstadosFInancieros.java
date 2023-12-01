import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
public class EstadosFInancieros{

    static final int intentosMaximos = 3;
    String nombreusuario;
    static int cantidadActivos =0,cantidadCapital=0,cantidadPasivos=0,cantidadGasto=0,cantidadIngreso=0,intentosMinimos=0;
        
    static Scanner leer = new Scanner(System.in);
    static LocalDate dia = LocalDate.now();
    static LocalTime hora = LocalTime.now();
    public static void main(String args[]){
        boolean reiniciar = true;
        String respuesta;
        while (reiniciar) {
            
        
        System.out.println("Bienvenido al programa de los estados Financieros " + hora + "\n se le preguntara un menu de acciones para elegir a su gusto ");
        System.out.println("\n 1.Balance General\n 2.Estado De Resultado \n 3. Salir de la aplicacion");
        System.out.println("Que opcion desea elegir?"); 
        int opcion=0;
        do{
            try {
    
            System.out.println("Ingrese un numero entre 1 y 3");
            opcion = leer.nextInt();

            if(opcion>0 && opcion <=4){
                System.out.println("Valores correctos");
                break;
            }else{
                System.out.println("Ingrese los Valores Adecuados");
                intentosMinimos++;
            }
             } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor no ingrese valores ilogicos");
                leer.nextLine();
                intentosMinimos++;
            }
        }while(intentosMinimos<3);
    
            switch (opcion) {
                case 1:
                    BalanceGenereal();
                    
                    System.out.println("Desea reiniciar el programa?(Si o No)");
                        respuesta = leer.next();
                        if(respuesta.equalsIgnoreCase("No")){
                            reiniciar = false;
                        }
                    break;

                    
                    case 2:

                    EstadoResultados();
                    System.out.println("Desea reiniciar el programa?(Si o No)");
                        respuesta = leer.next();
                        if(respuesta.equalsIgnoreCase("No")){
                            reiniciar = false;
                        }
                    break;

                    case 3:
                    EstadoFlujoEfectivo();
                    System.out.println("Desea reiniciar el programa?(Si o No)");
                        respuesta = leer.next();
                        if(respuesta.equalsIgnoreCase("No")){
                            reiniciar = false;
                        }
                    break;
                    
                default:
                System.out.println("Opcion no valida");
                System.out.println("Desea reiniciar el programa?(Si o No)");
                        respuesta = leer.next();
                        if(respuesta.equalsIgnoreCase("No")){
                            reiniciar = false;
                        }
                break;
            }
        }    
    }
    
     private static void EstadoResultados(){
        leer.nextLine();
        System.out.println("Bienvenid@ A continuacion Te presentaremos El estado de resultado de Tu negocio , conforme los productos que has adquirido y vendido:");
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

    private static void BalanceGenereal(){

        System.out.println("Desea ponerle nombre a las cuentas?");
        leer.nextLine();
        String respuesta = leer.nextLine();

        if(respuesta.equalsIgnoreCase("Si")){
        System.out.println("Ingrese la cantidad de activos");
        System.out.println("Ingrese el nombre de los activos");
        cantidadActivos = ObtenerValores(cantidadActivos);
        String nombreDeCuentaActivos [] = obtenerNombre("Activos", cantidadActivos);
        double activos[] = obtenerLosDatosConNombres("Activos", cantidadActivos, nombreDeCuentaActivos);
   
        System.out.println("Ingrese la cantidad de Pasivos");
        System.out.println("Ingrese el nombre de los Pasivos");
        cantidadPasivos = ObtenerValores(cantidadPasivos);
        String nombreDeCuentaPasivos [] = obtenerNombre("Pasivos", cantidadPasivos);
        double pasivos [] = obtenerLosDatosConNombres("Pasivos", cantidadActivos, nombreDeCuentaPasivos);

        System.out.println("Ingrese la cantidad de Capital");
        System.out.println("Ingrese el nombre del capital");
        cantidadCapital = ObtenerValores(cantidadCapital);
        String nombreDeCuentaCapital [] = obtenerNombre("Capital", cantidadCapital);
        double capital [] = obtenerLosDatosConNombres("Capital", cantidadCapital,nombreDeCuentaCapital);

        System.out.println("Ingrese la cantidad de ingresos");
        System.out.println("Ingrese el nombre de los ingresos");
        cantidadIngreso = ObtenerValores(cantidadIngreso);
        String nombreDeCuentaIngreso [] = obtenerNombre("Ingresos", cantidadIngreso);
        double ingresos [] = obtenerLosDatosConNombres("Ingresos", cantidadIngreso,nombreDeCuentaIngreso);

        System.out.println("Ingrese la cantidad de gastos");
        System.out.println("Ingrese el nombre de los gastos");
        cantidadGasto = ObtenerValores(cantidadGasto);
        String nombreDeCuentaGasto [] = obtenerNombre("Gastos", cantidadGasto);
        double gasto [] = obtenerLosDatosConNombres("Gastos", cantidadIngreso,nombreDeCuentaGasto);

        BalanceGenereal bg = new BalanceGenereal(activos, pasivos, capital, ingresos, gasto);

        System.out.println("Procernic \n Balance general \n " + dia);
        double verificacion = bg.Verificar1(ingresos,gasto);
        double verificacion2 =bg.Verificar2(activos,pasivos,capital);

        System.out.println(" Esta verificacion se realiza para saber si la resta de ingresos y gastos esta correcta " +verificacion);
        System.out.println(" Esta verificacion se realiza para saber si la suma del pasivo y capital da igual a los activos esta correcta " +verificacion2);

                       
        imprimirDatosConNombres("Activos", activos, nombreDeCuentaActivos);
        imprimirDatosConNombres("Pasivos", pasivos, nombreDeCuentaPasivos);
        imprimirDatosConNombres("Capital", capital, nombreDeCuentaCapital);
        imprimirDatosConNombres("Ingresos", ingresos, nombreDeCuentaIngreso);
        imprimirDatosConNombres("Gastos", gasto, nombreDeCuentaGasto);

        double resultadoDelBalance = bg.CalcularBalance();
        System.out.println("EL resultado del balance es " + resultadoDelBalance);

        if(resultadoDelBalance != 0.0){
            System.out.println("Si el resultado es de 0.0 el balance general cuadra \n Si por el contrario el balance da un error se le indicara en que parte esta el error\n si la verificacion 1 da un resultado de -1 hay un eeror en los ingresos y gastos\n si la verificacion 2 da -2 hay un error en en la parte de la suma del activo capital y pasivo");
        }
        }else{
                        
            System.out.println("Ingrese la cantidad de activos");
            cantidadActivos = ObtenerValores(cantidadActivos);
            double activos[] = obtenerLosDatos("Activos",cantidadActivos);

            System.out.println("Ingrese la cantidad de Pasivos");
            cantidadPasivos = ObtenerValores(cantidadPasivos);
            double pasivos [] = obtenerLosDatos("Pasivos", cantidadPasivos);

            System.out.println("Ingrese la cantidad de Capital");
            cantidadCapital = ObtenerValores(cantidadCapital);
            double capital [] = obtenerLosDatos("Capital", cantidadCapital);

            System.out.println("Ingrese la cantidad de ingresos");
            cantidadIngreso = ObtenerValores(cantidadIngreso);
            double ingresos [] = obtenerLosDatos("Ingresos",cantidadIngreso);

            System.out.println("Ingrese la cantidad de gastos");
            cantidadGasto = ObtenerValores(cantidadGasto);
            double gasto [] = obtenerLosDatos("Gastos",cantidadGasto);

            BalanceGenereal bg = new BalanceGenereal(activos, pasivos, capital, ingresos, gasto);

            double verificacion = bg.Verificar1(ingresos,gasto);
            double verificacion2 =bg.Verificar2(activos,pasivos,capital);

            System.out.println("Procernic \n Balance general \n " + dia);
                        
           

            imprimirDatos("Activo", activos);
            imprimirDatos("Pasivos", pasivos);
            imprimirDatos("Capital", capital);
            imprimirDatos("Ingresos", ingresos);
            imprimirDatos("Gastos", gasto);

            double resultadoDelBalance = bg.CalcularBalance();
            System.out.println("EL resultado del balance es " + resultadoDelBalance);

            if(resultadoDelBalance != 0.0){
            System.out.println(" Esta verificacion se realiza para saber si la resta de ingresos y gastos esta correcta " +verificacion);
            System.out.println(" Esta verificacion se realiza para saber si la suma del pasivo y capital da igual a los activos esta correcta " +verificacion2);
            System.out.println("Si el resultado es de 0.0 el balance general cuadra \n Si por el contrario el balance da un error se le indicara en que parte esta el error\n si la verificacion 1 da un resultado de -1 hay un eeror en los ingresos y gastos\n si la verificacion 2 da -2 hay un error en en la parte de la suma del activo capital y pasivo");
            }else{

                }
            }
    }

   
    private static void EstadoFlujoEfectivo(){
        int numCuentas = obtenerEnteroFlujo("Ingrese el número de cuentas: ");
        String[] cuentas = new String[numCuentas];
        double[] ingresos = new double[numCuentas];
        double[] egresos = new double[numCuentas];

        for (int i = 0; i < numCuentas; i++) {
            System.out.println("cuenta #" + (i + 1));
            cuentas[i] = obtenerCadenaFlujo("Nombre de la cuenta: ");
            ingresos[i] = obtenerDoubleFlujo("Ingresos para la cuenta: ");
            egresos[i] = obtenerDoubleFlujo("Egresos para la cuenta: ");
        }

        Arrays.sort(cuentas);

        FlujoEfectivo flujoEfectivo = new FlujoEfectivo(cuentas, ingresos, egresos);

        System.out.println("\nFlujo de efectivo neto: $" + flujoEfectivo.calcularFlujoEfectivoNeto());
    }

    private static int obtenerEnteroFlujo(String nota) {
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

    private static double obtenerDoubleFlujo(String nota) {
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

    private static String obtenerCadenaFlujo(String nota) {
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
    private static double[] obtenerLosDatos(String cuenta , int cantidad){
        double valores[] = new double[cantidad];
        int intentos=0;
        for(int i = 0; i<cantidad; i++){
            while (intentos < 3) {
                try {
                    System.out.println("Ingrese el nombre de la cuenta "+(i+1) + " y el valor de " + (i + 1) + " y la cuenta es " + cuenta);
                    valores[i] = leer.nextDouble();

                    // Validar que el valor no sea negativo
                    if (valores[i] >= 0) {
                        break; // Salir del bucle si la entrada es válida
                    } else {
                        System.out.println("Error: El valor no puede ser negativo. Intente de nuevo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un valor numérico. Intente de nuevo.");
                    leer.nextLine(); // Limpiar el buffer de entrada
                }

                intentos++;
            }

            if (intentos==2) {
                System.out.println("Ha excedido el número de intentos permitidos. Saliendo del programa.");
                break;
            }
        }
        return valores;
    }

    private static String[] obtenerNombre(String cuenta,int cantidad){
        String nombres[] = new String[cantidad];
        leer.nextLine();
        for(int i=0 ; i < cantidad; i++ ){
            System.out.println("Ingrese Los nombres para las cuentas de " + cuenta);
            nombres[i]=leer.nextLine();
        }
        return nombres;
    }

    private static double[] obtenerLosDatosConNombres(String cuenta , int cantidad,String nombre[]){    
        double valores[] = new double[cantidad];
        
        int intentos =0;
        for(int i =0 ; i<cantidad;i++){
            while (intentos < 3) {
                try {
                    System.out.println("Ingrese el nombre de la cuenta " + " y el valor de " + (i + 1) + " y la cuenta es " + cuenta);
                    valores[i] = leer.nextDouble();

                    // Validar que el valor no sea negativo
                    if (valores[i] >= 0) {
                        break; // Salir del bucle si la entrada es válida
                    } else {
                        System.out.println("Error: El valor no puede ser negativo. Intente de nuevo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un valor numérico. Intente de nuevo.");
                    leer.nextLine(); // Limpiar el buffer de entrada
                }

                intentos++;
            }

            if (intentos==2) {
                System.out.println("Ha excedido el número de intentos permitidos. Saliendo del programa.");
                break;
            }
    }
        return valores;
    }
        
        
    

    private static void imprimirDatosConNombres(String cuenta, double valores[], String nombres[]) {
        System.out.println("Cuenta: " + cuenta);
        double resultado =0;
        for (int i = 0; i < valores.length; i++) {
            System.out.println("Nombre: " + nombres[i] + ", Valor: " + valores[i]);
            resultado =+ valores[i];
        }
        System.out.println("La suma total de " + cuenta +" Es " + resultado);
        System.out.println("------------------------");
    }

     private static void imprimirDatos(String cuenta, double valores[]) {
        System.out.println("Cuenta: " + cuenta);
        double resultado =0;
        for (int i = 0; i < valores.length; i++) {
            System.out.println("El Valor de "+ (i+1)+" Es de" + valores[i]);
            resultado =+ valores[i];
        }
        System.out.println("La suma total de " + cuenta +" Es " + resultado);
        System.out.println("------------------------");
    }
    

    private static int ObtenerValores(int valores){

        int numero = 0;
        int intentos =3;
    
        for (int i = 0; i < intentos; i++) {
            try {
                System.out.print("Ingresa un numero positivo que este en un rango de 1 a 50 ");
                numero = leer.nextInt();

                if (numero <-1) {
                    System.out.println("Numero negativo ingresado. Intenta de nuevo.");
                } else if(numero>50) {
                    System.out.println("Se ah excedido del limite");
                }else{
                    return numero;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada no valida. Debes ingresar un numero entero.");
                leer.next(); // Limpiar el búfer del teclado
            }
        }

    System.out.println("Has alcanzado el limite de intentos. No se pudo ingresar un número positivo.");
    return numero;
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

