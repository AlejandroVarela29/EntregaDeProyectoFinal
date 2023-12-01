public class BalanceGenereal{
    
    private double activos[];
    private double pasivos[];
    private double capital[];
    private double ingresos[];
    private double gastos[];

    public BalanceGenereal(double activos[], double pasivos[], double capital[], double ingresos[], double gastos[]){
        this.activos = activos;
        this.pasivos = pasivos;
        this.capital = capital;
        this.ingresos = ingresos;
        this.gastos = gastos;
    }

    
    public double CalcularBalance(){
        double sumaActivos = sumatotal(activos);
        double sumaPasivos = sumatotal(pasivos);
        double sumaCapital = sumatotal(capital);
        double sumaIngresos = sumatotal(ingresos);
        double sumaGastos = sumatotal(gastos);

        return (sumaIngresos - sumaGastos) + (sumaActivos) - (sumaPasivos + sumaCapital);
    }

    public double Verificar1(double ingresos[], double gastos[]){
        double sumaIngresos = sumatotal(ingresos);
        double sumaGastos = sumatotal(gastos);
        if(sumaGastos!= sumaIngresos){
            return -1;
        }else{
            return 0;
        }
    }

    public double Verificar2(double activos[], double pasivos[], double capital[]){
        double sumaActivos = sumatotal(activos);
        double sumaPasivos = sumatotal(pasivos);
        double sumaCapital = sumatotal(capital);
        if(sumaActivos==(sumaPasivos+sumaCapital)){
            return 0;
        }else{
            return -2;
        }

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
    private double sumatotal(double cuenta[]){
        double suma =0;
        for(int i = 0 ; i<cuenta.length; i ++){
            suma =+ cuenta[i];
        }
        return suma;
    }

    public double[] getActivos() {
        return activos;
    }


    public void setActivos(double[] activos) {
        this.activos = activos;
    }


    public double[] getPasivos() {
        return pasivos;
    }


    public void setPasivos(double[] pasivos) {
        this.pasivos = pasivos;
    }


    public double[] getCapital() {
        return capital;
    }


    public void setCapital(double[] capital) {
        this.capital = capital;
    }

    //generar los getter y setter;
    
    
}